package org.pentaho.di.www;

import org.apache.commons.io.FileSystemUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.pentaho.di.i18n.BaseMessages;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * Created by pengpai  on 2015/12/24 0024.
 * 添加自定义远程carte的servlet方便与获取自定义信息与远程carte交互
 */
public class GetSlaveMonitorServlet extends BaseHttpServlet implements CartePluginInterface {
    private static Class<?> PKG = GetSlaveMonitorServlet.class;
    public static final String CONTEXT_PATH = "/kettle/slaveMonitor";
    public GetSlaveMonitorServlet() {
    }
    static String file  = System.getProperty("user.dir");
    SAXReader reader = new SAXReader();
    File xmlFile = new File(file+"/carte-config.xml");


    @Override
    public void init() throws ServletException {
        super.init();
        try {
            autoDeploySalve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
        自动插入节点信息到数据库中
     */
    public void autoDeploySalve(){
        Statement stmtrepo=null;
        Connection repoconn = null;
        Connection etlmconn = null;
        Statement stmtetlm = null;
        Map<String,String> slaveSql= null;
        Properties prop = new Properties();

        try {
            List<String> list = getRepoDBInfo();
            repoconn= DriverManager.getConnection(list.get(0), list.get(1), list.get(2));
            stmtrepo  = repoconn.createStatement();
            String sql = "SELECT * FROM d_databaseinfo where database_connection like '%etlm%'";
            ResultSet rs = stmtrepo.executeQuery(sql);
            String database_connection = "";
            String username = "";
            String password = "";
            while(rs.next()){
                database_connection = rs.getString("database_connection");
                username = rs.getString("username");
                password = rs.getString("password");
            }
            etlmconn = DriverManager.getConnection(database_connection,username,password);//获取连接etlm库jdbc
            boolean isUpdate = false;
            sql = "SELECT * FROM d_slave where hostname ='"+getHostname()+"'";
            stmtetlm = etlmconn.createStatement();
            rs = stmtetlm.executeQuery(sql);
            String slaveId = "";
            while(rs.next()){
                slaveId = rs.getInt("id")+"";
            }
            if(slaveId=="0"||"0".equals(slaveId)||slaveId==""||"".equals(slaveId)){
                isUpdate=false;
            }else{
                isUpdate=true;
            }
            if(etlmconn==null){
                System.out.println("没有etlm数据库连接!");
                throw new Exception();
            }else{
                if(isUpdate) {
                    slaveSql=readXMLForSql("update");
                    etlmconn.prepareStatement(slaveSql.get("dslaveSql")).executeUpdate();
                    System.out.println("更新节点信息成功!");
                }else{
                    slaveSql=readXMLForSql("insert");
                    System.out.println(slaveSql.get("dslaveSql"));
                    etlmconn.prepareStatement(slaveSql.get("dslaveSql")).executeUpdate();
                    sql = "SELECT * FROM d_slave where hostname ='"+getHostname()+"'";
                    stmtetlm = etlmconn.createStatement();
                    rs = stmtetlm.executeQuery(sql);
                    slaveId = "";
                    while(rs.next()){
                        slaveId = rs.getInt("id")+"";
                    }
                    etlmconn.prepareStatement(slaveSql.get("drepoSql").replace("$slave_id",slaveId)).executeUpdate();
                    System.out.println("插入新节点信息成功!");
                }
            }
            rs.close();
            stmtetlm.close();
            stmtrepo.close();
            etlmconn.close();
            repoconn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getRepoDBInfo(){
        Properties prop = new Properties();
        InputStream in = null;
        List list = new ArrayList();
        try {
            in = new BufferedInputStream(new FileInputStream(file + "/slave.properties"));
            prop.load(in);
            String DBInfos = prop.getProperty("DBInfos");
            String[] DBInfosArray = new String[1];
            if (DBInfos.contains(",")) {
                DBInfosArray = DBInfos.split(",");
            } else {
                DBInfosArray[0] = DBInfos;
            }
            String s = DBInfosArray[0];
            String ip = s.split(":")[1];;
            String port = s.split(":")[2].split("/")[0];
            String databasename = s.split("/")[1].split("&")[0];
            String repoName = ip+"_"+databasename;
            String repojdbc_connection = "jdbc:mysql://"+ip+":"+port+"/"+databasename+"?useUnicode=true&characterEncoding=utf8";
            String repousername = s.split("&")[1];
            String repopassword = s.split("&")[2];
            list.add(repojdbc_connection);
            list.add(repousername);
            list.add(repopassword);
            list.add(ip);
            list.add(repoName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Map readXMLForSql(String sqlType){//读取carte_config.xml文件中的配置信息

            Map<String,String> insertSql = new HashMap<>();
            String dslaveSql = "";
            String drepoSql = "";
            try {
                Map slaveInfoMap = getDBInfo();
                //repo 配置文件信息
                List<String> list = getRepoDBInfo();
                String slaveIp = (String) slaveInfoMap.get("slaveIp");
                String repoName = list.get(4);
                String slavePort = (String) slaveInfoMap.get("slavePort");
//            Document document = reader.read(xmlFile);
//            Element root = document.getRootElement();
//            Element slaveserver = root.element("slaveserver");
//            String port = slaveserver.elementText("port");
//            String slave_username = slaveserver.elementText("username");
//            String slave_password = slaveserver.elementText("password");
//            Element repository = root.element("repository");
//            String repo_name = repository.elementText("name");
//            String description = repository.elementText("description");
//            String repo_username = repository.elementText("username");
//            String repo_password = repository.elementText("password");
            if(sqlType=="insert"||sqlType.equals("insert")) {
                dslaveSql = "insert into " +
                      "d_slave(description,hostname,port,slave_username,slave_password) " +
                      "values('" + repoName + "','" + slaveIp + "','" + slavePort + "','cluster','cluster' )";
                drepoSql = "insert into d_user_slave_relation(user_id,slave_id) values(1,$slave_id)";
                insertSql.put("dslaveSql",dslaveSql);
                insertSql.put("drepoSql",drepoSql);
            }else if(sqlType=="update"||sqlType.equals("update")){
                dslaveSql = "update d_slave set " +
                        "description = '"+repoName+"',port = '"+slavePort+  "' where hostname='"+slaveIp+"'";
                insertSql.put("dslaveSql",dslaveSql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertSql;
    }

    public  Map getDBInfo(){
        Properties prop = new Properties();
        Map map = new HashMap();
        try{
            InputStream in = new BufferedInputStream(new FileInputStream(file+"/slave.properties"));
            // 修改配置文件路径
            prop.load(in);
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                if ((key.equals("DBInfos")) || (key.equals("slaveName")) || (key.equals("slavePort")) || (key.equals("slaveIp"))){
                    map.put(key,prop.getProperty(key));
                }
            }
            in.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return map;
    }
    public String getHostname(){
        String hostname = "";
        try {
            Document document = reader.read(xmlFile);
            Element root = document.getRootElement();
            Element slaveserver = root.element("slaveserver");
            hostname = slaveserver.elementText("hostname");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return hostname;
    }
    @Override
    public String getContextPath() {
        return CONTEXT_PATH;
    }
    @Override
    public String getService() {
        return CONTEXT_PATH + " (" + toString() + ")";
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        if ( isJettyMode() && !request.getContextPath().startsWith( CONTEXT_PATH ) ) {
            return;
        }
        if ( log.isDebug() ) {
            logDebug( BaseMessages.getString(PKG, "GetSlaveMonitorServlet.StatusRequested") );
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintStream out = new PrintStream(response.getOutputStream());
        try {
            int[] memInfo = getMemInfo();
//            out.println("MemTotal:" + memInfo[0]+"kb$");
            out.println(memInfo[1]+"kb$");
            out.println(disk()+"GB$");
            out.println(getCpuUsage()+"%$");
            out.println(getExtraLib()+"$");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        String isRestart =  request.getParameter("isRestart");
//        String slaveName =  request.getParameter("slaveName");
//        String slavePort =  request.getParameter("slavePort");
//        if(slaveName!=null&&!slaveName.isEmpty()){
//            try {
//                Document document = reader.read(xmlFile);
//                Element root = document.getRootElement();
//                Element slaveserver = root.element("slaveserver");
//                slaveserver.element("name").setText(slaveName);
//                saveDocument(document);
//                out.println( "更新节点名称为"+slaveName );
//            } catch (DocumentException e) {
//                e.printStackTrace();
//            }
//        }
//        if(slavePort!=null&&!slavePort.isEmpty()){
//            try {
//                Document document = reader.read(xmlFile);
//                Element root = document.getRootElement();
//                Element slaveserver = root.element("slaveserver");
//                slaveserver.element("port").setText(slavePort);
//                saveDocument(document);
//                out.println("更新节点端口为" + slavePort);
//            } catch (DocumentException e) {
//                e.printStackTrace();
//            }
//        }
//        if(isRestart!=null&&!isRestart.isEmpty()){
//            if(isRestart.equals("Y")||isRestart==("Y")){
//                try{
//                    Runtime.getRuntime().exec("sh restartCarte.sh");//在本地执行节点启动
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//        }
    }

    /**
     * 获取额外的第三方jar报信息
     * @return
     */
    public static String getExtraLib(){
        String slaveJar = "";
        try {
            HashSet<String> slaveJarSet = new HashSet<>();
            String[] cmd = new String[]{"/bin/sh","-c", "ls "};
            Process ps =Runtime.getRuntime().exec(cmd,null, new File(file+"/lib"));
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                slaveJarSet.add(line);
            }
            slaveJarSet.remove("ant-1.7.1.jar");
            slaveJarSet.remove("ant-launcher-1.7.1.jar");
            slaveJarSet.remove("antlr-2.7.7.jar");
            slaveJarSet.remove("antlr-3.4-complete.jar");
            slaveJarSet.remove("ascsapjco3wrp-20100529.jar");
            slaveJarSet.remove("asm-3.2.jar");
            slaveJarSet.remove("avalon-framework-4.1.5.jar");
            slaveJarSet.remove("axis-1.4.jar");
            slaveJarSet.remove("axis-saaj-1.4.jar");
            slaveJarSet.remove("axis2-adb-1.4.1.jar");
            slaveJarSet.remove("axis2-kernel-1.4.1.jar");
            slaveJarSet.remove("barbecue-1.5-beta1.jar");
            slaveJarSet.remove("barcode4j-2.0.jar");
            slaveJarSet.remove("batik-anim-1.7.jar");
            slaveJarSet.remove("batik-awt-util-1.7.jar");
            slaveJarSet.remove("batik-bridge-1.7.jar");
            slaveJarSet.remove("batik-codec-1.7.jar");
            slaveJarSet.remove("batik-css-1.7.jar");
            slaveJarSet.remove("batik-dom-1.7.jar");
            slaveJarSet.remove("batik-ext-1.7.jar");
            slaveJarSet.remove("batik-gui-util-1.7.jar");
            slaveJarSet.remove("batik-gvt-1.7.jar");
            slaveJarSet.remove("batik-parser-1.7.jar");
            slaveJarSet.remove("batik-script-1.7.jar");
            slaveJarSet.remove("batik-svg-dom-1.7.jar");
            slaveJarSet.remove("batik-transcoder-1.7.jar");
            slaveJarSet.remove("batik-util-1.7.jar");
            slaveJarSet.remove("batik-xml-1.7.jar");
            slaveJarSet.remove("bcmail-jdk14-138.jar");
            slaveJarSet.remove("bcprov-jdk14-138.jar");
            slaveJarSet.remove("bsf-2.4.0.jar");
            slaveJarSet.remove("bsh-1.3.0.jar");
            slaveJarSet.remove("cglib-nodep-2.2.jar");
            slaveJarSet.remove("commands-3.3.0-I20070605-0010.jar");
            slaveJarSet.remove("common-3.3.0-v20070426.jar");
            slaveJarSet.remove("commons-beanutils-1.8.0.jar");
            slaveJarSet.remove("commons-beanutils-core-1.8.0.jar");
            slaveJarSet.remove("commons-codec-1.5.jar");
            slaveJarSet.remove("commons-collections-3.2.1.jar");
            slaveJarSet.remove("commons-compress-1.4.jar");
            slaveJarSet.remove("commons-dbcp-1.4.jar");
            slaveJarSet.remove("commons-digester-1.8.jar");
            slaveJarSet.remove("commons-discovery-0.4.jar");
            slaveJarSet.remove("commons-httpclient-3.1.jar");
            slaveJarSet.remove("commons-io-2.1.jar");
            slaveJarSet.remove("commons-lang-2.6.jar");
            slaveJarSet.remove("commons-lang3-3.0.jar");
            slaveJarSet.remove("commons-logging-1.1.1.jar");
            slaveJarSet.remove("commons-math-1.1.jar");
            slaveJarSet.remove("commons-net-1.4.1.jar");
            slaveJarSet.remove("commons-pool-1.5.7.jar");
            slaveJarSet.remove("commons-validator-1.3.1.jar");
            slaveJarSet.remove("commons-vfs-20100924-pentaho.jar");
            slaveJarSet.remove("core-3.4.2.v_883_R34x.jar");
            slaveJarSet.remove("derby-10.2.1.6.jar");
            slaveJarSet.remove("derbyclient-10.2.1.6.jar");
            slaveJarSet.remove("dom4j-1.6.1.jar");
            slaveJarSet.remove("drools-api-5.0.1.jar");
            slaveJarSet.remove("drools-compiler-5.0.1.jar");
            slaveJarSet.remove("drools-core-5.0.1.jar");
            slaveJarSet.remove("edtftpj-2.1.0.jar");
            slaveJarSet.remove("ehcache-core-2.5.1.jar");
            slaveJarSet.remove("eigenbase-properties-1.1.2.jar");
            slaveJarSet.remove("eigenbase-resgen-1.3.1.jar");
            slaveJarSet.remove("eigenbase-xom-1.3.1.jar");
            slaveJarSet.remove("elasticsearch-0.16.3.jar");
            slaveJarSet.remove("esapi-2.0.1.jar");
            slaveJarSet.remove("feed4j-1.0.jar");
            slaveJarSet.remove("flute-5.4.0.1-130.jar");
            slaveJarSet.remove("ftp4che-0.7.1.jar");
            slaveJarSet.remove("georss-rome-0.9.8.jar");
            slaveJarSet.remove("groovy-1.8.0.jar");
            slaveJarSet.remove("guava-17.0.jar");
            slaveJarSet.remove("h2-1.2.131.jar");
            slaveJarSet.remove("hibernate-c3p0-3.6.9.Final.jar");
            slaveJarSet.remove("hibernate-commons-annotations-3.2.0.Final.jar");
            slaveJarSet.remove("hibernate-core-3.6.9.Final.jar");
            slaveJarSet.remove("hibernate-ehcache-3.6.9.Final.jar");
            slaveJarSet.remove("hsqldb-1.8.0.7.jar");
            slaveJarSet.remove("infobright-core-3.4.jar");
            slaveJarSet.remove("ini4j-0.5.1.jar");
            slaveJarSet.remove("itext-2.1.7.jar");
            slaveJarSet.remove("itext-rtf-2.1.7.jar");
            slaveJarSet.remove("jackcess-1.2.6.jar");
            slaveJarSet.remove("jackson-core-asl-1.9.2.jar");
            slaveJarSet.remove("jackson-jaxrs-1.9.2.jar");
            slaveJarSet.remove("jackson-mapper-asl-1.9.2.jar");
            slaveJarSet.remove("janino-2.5.16.jar");
            slaveJarSet.remove("javacc-5.0.jar");
            slaveJarSet.remove("javacup-10k.jar");
            slaveJarSet.remove("javadbf-20081125.jar");
            slaveJarSet.remove("javassist-3.12.1.GA.jar");
            slaveJarSet.remove("jaxen-1.1.1.jar");
            slaveJarSet.remove("jaxrpc-api-1.1.jar");
            slaveJarSet.remove("jaybird-2.1.6.jar");
            slaveJarSet.remove("jcifs-1.3.3.jar");
            slaveJarSet.remove("jcommon-1.0.16.jar");
            slaveJarSet.remove("jersey-apache-client-1.16.jar");
            slaveJarSet.remove("jersey-bundle-1.16.jar");
            slaveJarSet.remove("jersey-client-1.16.jar");
            slaveJarSet.remove("jersey-core-1.16.jar");
            slaveJarSet.remove("jetty-6.1.21.jar");
            slaveJarSet.remove("jetty-plus-6.1.21.jar");
            slaveJarSet.remove("jetty-util-6.1.21.jar");
            slaveJarSet.remove("jface-3.3.0-I20070606-0010.jar");
            slaveJarSet.remove("jfreechart-1.0.13.jar");
            slaveJarSet.remove("jlfgr-1.0.jar");
            slaveJarSet.remove("jmi-200507110943.jar");
            slaveJarSet.remove("jmiutils-200507110943.jar");
            slaveJarSet.remove("joda-time-1.6.jar");
            slaveJarSet.remove("js-1.7R3.jar");
            slaveJarSet.remove("jsch-0.1.46.jar");
            slaveJarSet.remove("jsendnsca-2.0.1.jar");
            slaveJarSet.remove("json-simple-1.1.jar");
            slaveJarSet.remove("jsonpath-1.0.jar");
            slaveJarSet.remove("jsp-api-2.0.jar");
            slaveJarSet.remove("jt400-6.1.jar");
            slaveJarSet.remove("jtds-1.2.5.jar");
            slaveJarSet.remove("jug-lgpl-2.0.0.jar");
            slaveJarSet.remove("jxl-2.6.12.jar");
            slaveJarSet.remove("kettle-core-5.4.0.1-130.jar");
            slaveJarSet.remove("kettle-dbdialog-5.4.0.1-130.jar");
            slaveJarSet.remove("kettle-engine-5.4.0.1-130.jar");
            slaveJarSet.remove("kettle-ui-swt-5.4.0.1-130.jar");
            slaveJarSet.remove("kettle5-log4j-plugin-5.4.0.1-130.jar");
            slaveJarSet.remove("ldapjdk-20000524.jar");
            slaveJarSet.remove("libbase-5.4.0.1-130.jar");
            slaveJarSet.remove("libdocbundle-5.4.0.1-130.jar");
            slaveJarSet.remove("libfonts-5.4.0.1-130.jar");
            slaveJarSet.remove("libformat-5.4.0.1-130.jar");
            slaveJarSet.remove("libformula-5.4.0.1-130.jar");
            slaveJarSet.remove("libloader-5.4.0.1-130.jar");
            slaveJarSet.remove("libpixie-5.4.0.1-130.jar");
            slaveJarSet.remove("librepository-5.4.0.1-130.jar");
            slaveJarSet.remove("libserializer-5.4.0.1-130.jar");
            slaveJarSet.remove("libsparkline-5.4.0.1-130.jar");
            slaveJarSet.remove("libswing-5.4.0.1-130.jar");
            slaveJarSet.remove("libxml-5.4.0.1-130.jar");
            slaveJarSet.remove("log4j-1.2.17.jar");
            slaveJarSet.remove("LucidDbClient-minimal-0.9.4.jar");
            slaveJarSet.remove("mail-1.4.7.jar");
            slaveJarSet.remove("mdrapi-200507110943.jar");
            slaveJarSet.remove("metastore-5.4.0.1-130.jar");
            slaveJarSet.remove("mof-200507110943.jar");
            slaveJarSet.remove("mondrian-3.10.0.1-130.jar");
            slaveJarSet.remove("monetdb-jdbc-2.8.jar");
            slaveJarSet.remove("mstor-0.9.13.jar");
            slaveJarSet.remove("mvel2-2.0.10.jar");
            slaveJarSet.remove("nbmdr-200507110943-custom.jar");
            slaveJarSet.remove("nekohtml-1.9.15.jar");
            slaveJarSet.remove("odfdom-java-0.8.6.jar");
            slaveJarSet.remove("ognl-2.6.9.jar");
            slaveJarSet.remove("olap4j-1.2.0.jar");
            slaveJarSet.remove("olap4j-xmla-1.2.0.jar");
            slaveJarSet.remove("openide-util-200507110943.jar");
            slaveJarSet.remove("oro-2.0.8.jar");
            slaveJarSet.remove("pentaho-connections-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-cwm-1.5.4.jar");
            slaveJarSet.remove("pentaho-database-model-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-hadoop-hive-jdbc-shim-54.2015.06.01.jar");
            slaveJarSet.remove("pentaho-metadata-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-registry-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-core-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-drill-down-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-kettle-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-mondrian-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-olap4j-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-pmd-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-reportdesigner-parser-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-sampledata-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-scripting-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-toc-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-classic-extensions-xpath-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-legacy-charts-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-legacy-functions-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-reporting-engine-wizard-core-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-vfs-browser-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-xul-core-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-xul-swing-5.4.0.1-130.jar");
            slaveJarSet.remove("pentaho-xul-swt-5.4.0.1-130.jar");
            slaveJarSet.remove("poi-3.9.jar");
            slaveJarSet.remove("poi-ooxml-3.9.jar");
            slaveJarSet.remove("poi-ooxml-schemas-3.9.jar");
            slaveJarSet.remove("postgresql-9.3-1102-jdbc4.jar");
            slaveJarSet.remove("rome-1.0.jar");
            slaveJarSet.remove("rsyntaxtextarea-1.3.2.jar");
            slaveJarSet.remove("sac-1.3.jar");
            slaveJarSet.remove("salesforce-partner-24.0.jar");
            slaveJarSet.remove("sapdbc-7.4.4.jar");
            slaveJarSet.remove("SassyReader-0.5.jar");
            slaveJarSet.remove("saxon-9.1.0.8.jar");
            slaveJarSet.remove("saxon-dom-9.1.0.8.jar");
            slaveJarSet.remove("scannotation-1.0.2.jar");
            slaveJarSet.remove("secondstring-20060615.jar");
            slaveJarSet.remove("servlet-api-2.5.jar");
            slaveJarSet.remove("simple-jndi-1.0.1.jar");
            slaveJarSet.remove("slf4j-api-1.7.5.jar");
            slaveJarSet.remove("slf4j-log4j12-1.7.5.jar");
            slaveJarSet.remove("snakeyaml-1.7.jar");
            slaveJarSet.remove("snappy-java-1.1.0.jar");
            slaveJarSet.remove("snmp4j-1.9.3d.jar");
            slaveJarSet.remove("spring-2.5.6.jar");
            slaveJarSet.remove("spring-core-2.5.6.jar");
            slaveJarSet.remove("sqlite-jdbc-3.7.2.jar");
            slaveJarSet.remove("stax-1.2.0.jar");
            slaveJarSet.remove("stax-api-1.0.1.jar");
            slaveJarSet.remove("syslog4j-0.9.34.jar");
            slaveJarSet.remove("trilead-ssh2-build213.jar");
            slaveJarSet.remove("validation-api-1.0.0.GA.jar");
            slaveJarSet.remove("wsdl4j-1.6.2.jar");
            slaveJarSet.remove("wsdl4j-qname-1.6.1.jar");
            slaveJarSet.remove("wstx-asl-3.2.4.jar");
            slaveJarSet.remove("xalan-2.6.0.jar");
            slaveJarSet.remove("xercesImpl-2.9.1.jar");
            slaveJarSet.remove("xml-apis-2.0.2.jar");
            slaveJarSet.remove("xml-apis-ext-1.3.04.jar");
            slaveJarSet.remove("xmlbeans-2.5.0.jar");
            slaveJarSet.remove("xmlpull-1.1.3.1.jar");
            slaveJarSet.remove("xpp3_min-1.1.4c.jar");
            slaveJarSet.remove("xstream-1.4.2.jar");
            for(Iterator<String> it=slaveJarSet.iterator();it.hasNext();)
            {
                String str=it.next();
                slaveJar = slaveJar+str+", ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return slaveJar;
    }
    public static int[] getMemInfo() throws IOException, InterruptedException {//获取内存信息
        File file = new File("/proc/meminfo");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)));
        int[] result = new int[4];
        String str = null;
        StringTokenizer token = null;
        while ((str = br.readLine()) != null) {
            token = new StringTokenizer(str);
            if (!token.hasMoreTokens())
                continue;

            str = token.nextToken();
            if (!token.hasMoreTokens())
                continue;


            if (str.equalsIgnoreCase("MemFree:"))
                result[1] = Integer.parseInt(token.nextToken());

        }
        System.out.println(result);
        return result;
    }

    public static double getCpuUsage(){//获取主机cpu信息
        double cpuUsed = 0;
        double idleUsed = 0.0;
        Runtime rt = Runtime.getRuntime();
        try {
             Process p = rt.exec("top -b -n 1");
             BufferedReader in = null;

            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String str = null;
            int linecount = 0;
            while ((str = in.readLine()) != null) {
                linecount++;
                if (linecount == 3) {
                    String[] s = str.split(",");
                    String idlestr = s[3];
                        if(idlestr.contains("%")) {
                            String idlestr1[] = idlestr.split("%");
                            idleUsed = Double.parseDouble(idlestr1[0].trim());
                            cpuUsed = 100 - idleUsed;
                            break;
                        }else{
                            String idlestr1[] = idlestr.split("id");
                            idleUsed = Double.parseDouble(idlestr1[0].trim());
                            cpuUsed = 100 - idleUsed;
                            break;
                        }
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cpuUsed);
        return cpuUsed;
        }
    /**
     * 功能：可用磁盘
     * */
    public static int disk() {//获取主机硬盘信息
        try {
            long total = FileSystemUtils.freeSpaceKb("/home");
            double disk = (double) total / 1024 / 1024;
            System.out.println(disk);
            return (int) disk;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
