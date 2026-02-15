package OOPS.abstraction.UsingInterfaces;

public class CloudeSystem {
    interface CloudeStorage{
        void uploadFile(String fileName);
        void downloadFile(String fileName);
    }

    static class AWS implements CloudeStorage {
        @Override
        public void uploadFile(String fileName) {
            System.out.println("uploading " + fileName + " to AWS");
        }

        @Override
        public void downloadFile(String fileName) {
            System.out.println("downloading " + fileName + " from AWS");
        }
    }
    static class GoogleDrive implements CloudeStorage{
        @Override
        public void uploadFile(String fname){
            System.out.println("uploading "+fname+" to Google Drive");
        }
        @Override
        public void downloadFile(String fname){
        }
    }
    static class BackupService {
     private CloudeStorage storage;

     BackupService(CloudeStorage storage){
         this.storage = storage;
     }
     void runBackup(String fileName){
         storage.uploadFile(fileName);
         System.out.println("Backup operation completed.");
     }
    }

    public static void main(String[] args){
        CloudeStorage provider = new GoogleDrive();
        provider.uploadFile("image");
        provider.downloadFile("image");

        BackupService myApp = new BackupService(provider);
        myApp.runBackup("backup image");

        System.out.println("switching provider.");
        provider = new AWS();
        myApp = new BackupService(provider);
        myApp.runBackup("Image Dump");
    }
}
