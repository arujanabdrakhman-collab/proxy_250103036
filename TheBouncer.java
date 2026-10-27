interface Image{
    public void show();
}

class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName=fileName;
        System.out.println("reading" + fileName);
    }
    public void show(){
        System.out.println("showing" + fileName);
    }
}

class ProxyImage implements Image{
    private String fileName;
    private String userRole;
    private RealImage realImage;

    public ProxyImage(String fileName, String userRole){
        this.fileName = fileName;
        this.userRole = userRole;
    }

    public void show(){
        if(!userRole.equals("ADMIN")){
            System.out.println("you cant enter"+userRole);
            return;
        }
        if(realImage==null){
            realImage=new RealImage(fileName);
        }
        realImage.show();
    }
}

public class TheBouncer{
    public static void main(String[] args){
        Image guest = new ProxyImage("salary_sheet.png", "GUEST");
        Image admin = new ProxyImage("salary_sheet.png", "ADMIN");

        guest.show();
        admin.show();
    }
}