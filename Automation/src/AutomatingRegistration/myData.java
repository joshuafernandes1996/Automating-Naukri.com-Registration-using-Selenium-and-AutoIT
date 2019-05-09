package AutomatingRegistration;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellType;

public class myData {

    private String Name;
    private String Email;
    private String Password;
    private String Mobile;
    private String Location;
    private String City;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setData(HSSFSheet sheet) {
        this.setName(sheet.getRow(1).getCell(0).getStringCellValue());
        this.setEmail(sheet.getRow(1).getCell(1).getStringCellValue());
        this.setPassword(sheet.getRow(1).getCell(2).getStringCellValue());
        sheet.getRow(1).getCell(3).setCellType(CellType.STRING);
        this.setMobile(sheet.getRow(1).getCell(3).getStringCellValue());
        this.setLocation(sheet.getRow(1).getCell(4).getStringCellValue());
        this.setCity(sheet.getRow(1).getCell(5).getStringCellValue());
    }
}
