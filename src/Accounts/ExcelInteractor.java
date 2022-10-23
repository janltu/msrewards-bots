package Accounts;

import Debug.ConsoleOut;
import com.aspose.cells.*;
import java.io.*;

public class ExcelInteractor {

    // Convert Xlsx to User
    public static User[] ConvertXlsxToUserList() {
        char sep = File.separatorChar;

        // Open workbook (xlsx) & get main sheet
        Workbook wb = OpenXlsxFile("data" + sep + "Users.xlsx");
        Worksheet sheet = wb.getWorksheets().get(0);

        int rowCount = sheet.getCells().getRows().getCount();

        User[] userList = new User[rowCount-1];

        // Foreach row (except the first) collect email, password, balance entries
        // pack them to a User object & add them to userList
        for (int i = 2; i <= rowCount; i++) {
            String emailLocation = "A" + i;
            String passwordLocation = "B" + i;
            String balanceLocation = "C" + i;

            User currentUser = new User(
                    sheet.getCells().get(emailLocation).getValue().toString(),
                    sheet.getCells().get(passwordLocation).getValue().toString(),
                    (int)Double.parseDouble( sheet.getCells().get(balanceLocation).getValue().toString() )
            );

            userList[i-2] = currentUser;
        }

        ConsoleOut.Success("Converted xlsx to userList");
        return userList;
    }

    // Save Xlsx log
    public static void LogUserListAsXlsx(User[] userList) {
        Workbook wb = new Workbook();
        Worksheet sheet = wb.getWorksheets().get(0);

        // Style the & fill the title bar
        Cell c1 = sheet.getCells().get("A" + 1);
        Cell c2 = sheet.getCells().get("B" + 1);
        Cell c3 = sheet.getCells().get("C" + 1);

        c1.setValue("Email");
        c2.setValue("Password");
        c3.setValue("Balance");

        // Populate the rows with user data
        int currentRow = 2;
        for (User user: userList) {
            sheet.getCells().get("A" + currentRow).setValue( userList[currentRow-2].Mail );
            sheet.getCells().get("B" + currentRow).setValue( userList[currentRow-2].Password );
            sheet.getCells().get("C" + currentRow).setValue( userList[currentRow-2].Balance );
            currentRow++;
        }

        // Get string for path creation
        String currentDate = java.time.LocalDate.now().toString().replace('-', '.');
        String currentTime = java.time.LocalTime.now().toString().split("[.]")[0].replace(':', '-');
        char sep = File.separatorChar;

        // Save file to & as
        SaveXlsxFile(wb, "Users[" + currentDate + "'" + currentTime + "]");

        ConsoleOut.Success("Saved new xlsx file");
    }

    // Helper functions
    private static Workbook OpenXlsxFile(String path){
        File excelFile = new File(path);
        FileInputStream excelInput = null;
        Workbook wb = null;

        try{
            excelInput = new FileInputStream(excelFile);
        } catch (FileNotFoundException e){
            ConsoleOut.Error(e.getMessage() + '\n');
        }

        try{
            wb = new Workbook(excelInput);
        } catch (Exception e){
            ConsoleOut.Error(e.getMessage() + '\n');
        }

        return wb;
    }

    private static void SaveXlsxFile(Workbook wb, String name){
        // Get Separator
        char sep = File.separatorChar;

        // Try to save
        try{
            wb.save("data" + sep + name + ".xlsx");
        } catch (Exception e){
            ConsoleOut.Error(e.getMessage() + '\n');
        }
    }
}
