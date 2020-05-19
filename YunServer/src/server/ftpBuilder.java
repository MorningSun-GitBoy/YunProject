package server;

public class ftpBuilder {
    private String upload;
    private String download;
    public ftpBuilder(){
        this.upload = "STOR";
        this.download = "RETR";
    }
    public FtpLoad UploadFtp(int port){return new FtpLoad(port, upload);}
    public FtpLoad DownloadFtp(int port){return new FtpLoad(port, download);}
}