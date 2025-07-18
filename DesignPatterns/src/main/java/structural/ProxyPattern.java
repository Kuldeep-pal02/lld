package structural;

public class ProxyPattern {

    public static void main(String[] args) {
        VideoDownloader videoDownloader = new RVDProxy( new RealVideoDownloader() );
        videoDownloader.download();
    }
}

interface VideoDownloader{
    void download();
}
class RealVideoDownloader implements VideoDownloader{

    @Override
    public void download() {
        System.out.println( "Real Fast download");
    }
}
class RVDProxy implements VideoDownloader{

    private RealVideoDownloader realVideoDownloader;
    RVDProxy( RealVideoDownloader realVideoDownloader ){
        this.realVideoDownloader = realVideoDownloader;
    }
    @Override
    public void download() {
        //Add extra feature
        System.out.println("Proxy Started");
        realVideoDownloader.download();
        System.out.println("Proxy Ended");
    }
}
