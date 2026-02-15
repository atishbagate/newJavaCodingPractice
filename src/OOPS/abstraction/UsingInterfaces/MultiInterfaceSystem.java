package OOPS.abstraction.UsingInterfaces;

public class MultiInterfaceSystem {
    interface WIFIEnabled{
        void connectToWIFI(String network);
    }
    interface CloudStorage{
        void uploadFile(String fileName);
    }

    static abstract class ElectronicDevice{
        String modal;
        ElectronicDevice(String modal){
            this.modal = modal;
        }
        void powerOn(){
            System.out.println(modal+" is powered on.");
        }
    }
    static class SmartPhone extends ElectronicDevice implements WIFIEnabled, CloudStorage {
        SmartPhone(String modal) {
            super(modal);
        }

        @Override
        public void uploadFile(String fileName) {
            System.out.println(modal + " is uploading " + fileName + " to cloud.");
        }

        public void connectToWIFI(String network) {
            System.out.println(modal + " connected to " + network);
        }

        public static void main(String[] args) {
            SmartPhone myPhone = new SmartPhone("iPhone 15");
            myPhone.powerOn();
            myPhone.connectToWIFI("Home_Network");
            myPhone.uploadFile("photo.jpg");


            System.out.println("to check for polymorphism");
            System.out.println("is it a device "+(myPhone instanceof ElectronicDevice));
            System.out.println("is it wifi enabled "+(myPhone instanceof WIFIEnabled));
            System.out.println("is it cloud storage"+(myPhone instanceof CloudStorage));
        }

    }
}
