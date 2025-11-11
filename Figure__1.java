public class Fig1 {
    public static void main(String[] args) {
        System.out.println("=== Fig 1: Interface Segregation Principle ===");
        Amazon amazon = new Amazon();
        amazon.createServer("Asia-East");
        amazon.listServers("Asia-East");
        amazon.getCDNAddress();
        amazon.storeFile("report.pdf");

        Dropbox dropbox = new Dropbox();
        dropbox.storeFile("photo.png");
        dropbox.getFile("photo.png");
    }
}

// ---------- Helper Classes ----------
interface CloudHostingProvider {
    void createServer(String region);
    void listServers(String region);
}

interface CDNProvider {
    void getCDNAddress();
}

interface CloudStorageProvider {
    void storeFile(String name);
    void getFile(String name);
}

class Amazon implements CloudHostingProvider, CDNProvider, CloudStorageProvider {
    public void createServer(String region) { System.out.println("Amazon: Server created in " + region); }
    public void listServers(String region) { System.out.println("Amazon: Listing servers in " + region); }
    public void getCDNAddress() { System.out.println("Amazon: Getting CDN address"); }
    public void storeFile(String name) { System.out.println("Amazon: Storing " + name); }
    public void getFile(String name) { System.out.println("Amazon: Getting " + name); }
}

class Dropbox implements CloudStorageProvider {
    public void storeFile(String name) { System.out.println("Dropbox: Storing " + name); }
    public void getFile(String name) { System.out.println("Dropbox: Getting " + name); }
}
