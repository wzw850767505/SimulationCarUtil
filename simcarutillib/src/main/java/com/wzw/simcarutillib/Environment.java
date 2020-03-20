package com.wzw.simcarutillib;



public class Environment
{
    static Environment environment;
    String logPath;
    public static Environment getInstance() {
        if(environment == null){
            environment = new Environment();
//            workerGroup = new NioEventLoopGroup();
        }
        return environment;
    }
//    private IDb db;
//    private IGpsData gpsData;
//    static EventLoopGroup workerGroup;
//    //视频相关控制器
//    private IVideoClient live;
//    //设备通用功能
//    private IUtilityClient utilityClient;
//    //吉标司机库控制器
//    private IDriverClient driverClient;
//    private ILifeClient lifeClient;
//    private ILog log;
//    public void setDb(IDb db){
//        this.db = db;
//    }
//    public IDb getDb(){
//        return db;
//    }
//
//    public IGpsData getGpsData() {
//        return gpsData;
//    }
//
//    public void setGpsData(IGpsData gpsData) {
//        this.gpsData = gpsData;
//    }
//
//    public ILog getLog() {
//        return log;
//    }
//    public void setLog(ILog log) {
//        this.log = log;
//    }
//
//    public IVideoClient getViceoClient() {
//        return live;
//    }
//
//    public void setVideoClient(IVideoClient live) {
//        this.live = live;
//    }
//
//    public IUtilityClient getUtilityClient() {
//        return utilityClient;
//    }
//
//    public void setUtilityClient(IUtilityClient utilityClient) {
//        this.utilityClient = utilityClient;
//    }
//
//    public EventLoopGroup getWorkerGroup() {
//        return workerGroup;
//    }
//
//    public void setLogPath(String logpath) {
//        this.logPath=logpath;
//    }
//
//    public String getLogPath() {
//        return logPath;
//    }
//
//    public IDriverClient getDriverClient() {
//        return driverClient;
//    }
//
//    public void setDriverClient(IDriverClient driverClient) {
//        this.driverClient = driverClient;
//    }
//
//    public ILifeClient getLifeClient() {
//        return lifeClient;
//    }
//
//    public void setLifeClient(ILifeClient lifeClient) {
//        this.lifeClient = lifeClient;
//    }
}

