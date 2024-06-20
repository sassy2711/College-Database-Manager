
//STEP 1. Import required packages
import java.util.*;
import java.sql.*;

public class JdbcDemo {
   static Connection conn = null;
   static Scanner sc = new Scanner(System.in);
   static int command;
   static String buffer;

   public static void displayMenu() {
      System.out.print("*************************");
      System.out.print("Menu");
      System.out.println("*************************");
      System.out.println("The following are the commands and their corresponding operations:-");
      System.out.println("0 - Stop");
      System.out.println("1 - ADD Prof");
      System.out.println("2 - ADD Dept");
      System.out.println("3 - ADD Administrator");
      System.out.println("4 - ADD Student");
      System.out.println("5 - ADD Staff");
      System.out.println("6 - SHOW ALL Profs");
      System.out.println("7 - SHOW ALL Depts");
      System.out.println("8 - SHOW ALL Administrators");
      System.out.println("9 - SHOW ALL Students");
      System.out.println("10 - SHOW ALL Staffs");
      System.out.println("11 - REMOVE Prof");
      System.out.println("12 - REMOVE Dept");
      System.out.println("13 - REMOVE Administrator");
      System.out.println("14 - REMOVE Student");
      System.out.println("15 - REMOVE Staff");
      System.out.println("16 - UPDATE Prof Age");
      System.out.println("17 - UPDATE Department Name");
      System.out.println("18 - UPDATE Administrator id");
      System.out.println("19 - UPDATE Student Age");
      System.out.println("20 - UPDATE Staff Experience");
      System.out.println("21 - SHOW Oldest Prof in a Department");
      System.out.println("22 - ADD Prof AS Dean");
      System.out.println("23 - SHOW Profs in a Department");
      System.out.println("24 - SHOW Prof Locations");
      System.out.println("25 - ADD Dept and UPDATE Prof Department");
   }

   public static void useDB(Statement stmt) {   //uses the db
      String sql = "use college";
      try {
         stmt.executeUpdate(sql);
         conn.commit();
      }
      catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }
   }

//CRUD OPERATIONS:-

   //ADD operations for each table

   public static void addProf(Statement stmt) {
      System.out.println("Prof ID: ");
      int prof_id = sc.nextInt();
      buffer = sc.nextLine();
      System.out.println("Prof Name: ");
      String name = sc.nextLine();
      System.out.println("Prof Age: ");
      int age = sc.nextInt();
      buffer = sc.nextLine();
      System.out.println("Prof Department: ");
      String dept = sc.nextLine();

      String sql = "INSERT INTO Prof VALUES (%d, '%s', %d, '%s')";
      sql = String.format(sql, prof_id, name, age, dept);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      }

      catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Prof Added Successfully.");
      System.out.println();
   }

   public static void addStudent(Statement stmt) {
      System.out.println("Student ID: ");
      int student_id = sc.nextInt();
      buffer = sc.nextLine();
      System.out.println("Student Name: ");
      String name = sc.nextLine();
      System.out.println("Student Age: ");
      int age = sc.nextInt();
      buffer = sc.nextLine();

      String sql = "INSERT INTO Students VALUES (%d, '%s', %d)";
      sql = String.format(sql, student_id, name, age);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Student Added Successfully.");
      System.out.println();
   }

   public static void addStaff(Statement stmt) {
      System.out.println("Staff ID: ");
      int staff_id = sc.nextInt();
      buffer = sc.nextLine();
      System.out.println("Staff Name: ");
      String name = sc.nextLine();
      System.out.println("Staff Experience: ");
      int experience = sc.nextInt();
      buffer = sc.nextLine();

      String sql = "INSERT INTO Staff VALUES (%d, '%s', %d)";
      sql = String.format(sql, staff_id, name, experience);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Staff Added Successfully.");
      System.out.println();
   }

   public static void addDepartment(Statement stmt) {
      System.out.println("Department ID: ");
      int department_id = sc.nextInt();
      buffer = sc.nextLine();
      System.out.println("Department Name: ");
      String name = sc.nextLine();
      System.out.println("Department Location: ");
      String location = sc.nextLine();

      String sql = "INSERT INTO Department VALUES (%d, '%s', '%s')";
      sql = String.format(sql, department_id, name, location);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Department Added Successfully.");
      System.out.println();
   }

   public static void addAdministrator(Statement stmt) {
      System.out.println("Admin ID: ");
      int admin_id = sc.nextInt();
      buffer = sc.nextLine();
      System.out.println("Position: ");
      String position = sc.nextLine();

      String sql = "INSERT INTO Administration VALUES (%d, '%s')";
      sql = String.format(sql, admin_id, position);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Administrator Added Successfully.");
      System.out.println();
   }


   //RETREIVAL Operations for each table

   public static void showProfs(Statement stmt) {
      try {
         String sql = "SELECT * FROM Prof";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println();
         while (rs.next()) {
            System.out.println("Prof ID: " + rs.getInt("prof_id") + ", Prof Name: " + rs.getString("name")
                  + ", Prof Age: " + rs.getInt("age"));
         }
         System.out.println();
         rs.close();
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }

   public static void showStudents(Statement stmt) {
      try {
         String sql = "SELECT * FROM Students";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println();
         while (rs.next()) {

            System.out.println("Student ID: " + rs.getInt("student_id") + ", Name: " + rs.getString("name")
                  + ", Age: " + rs.getInt("age"));
         }
         System.out.println();
         rs.close();
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }

   public static void showStaff(Statement stmt) {
      try {
         String sql = "SELECT * FROM Staff";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println();
         while (rs.next()) {
            System.out.println("Staff ID: " + rs.getInt("staff_id") + ", Name: " + rs.getString("name")
                  + ", Experience: " + rs.getInt("experience"));
         }
         System.out.println();
         rs.close();
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }

   public static void showDepartments(Statement stmt) {
      try {
         String sql = "SELECT * FROM Department";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println();
         while (rs.next()) {
            System.out.println("Department ID: " + rs.getInt("department_id") + ", Name: " + rs.getString("name")
                  + ", Location: " + rs.getString("location"));
         }
         System.out.println();
         rs.close();
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }

   public static void showAdministrators(Statement stmt) {
      try {
         String sql = "SELECT prof_id, name, position FROM Administration, Prof where prof_id = admin_id";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println();
         while (rs.next()) {
            System.out.println("Prof_id: " + rs.getInt("prof_id") + ", Prof_Name: " + rs.getString("name") + ", Position: " + rs.getString("position"));
         }
         System.out.println();
         rs.close();
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }


   //UPDATE operations for each table

   public static void updateProfAge(Statement stmt) {
      System.out.println("Prof ID: ");
      int prof_id = sc.nextInt();
      sc.nextLine(); // Consume newline
      System.out.println("New Age: ");
      int age = sc.nextInt();
      sc.nextLine(); // Consume newline

      String sql = "UPDATE Prof SET age = %d WHERE prof_id = %d";
      sql = String.format(sql, age, prof_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
         System.out.println("Professor age updated successfully.");
      } catch (SQLException se) {
         System.out.println(se.getMessage());
      }
   }

   public static void updateDepartmentName(Statement stmt) {
      System.out.println("Department ID: ");
      int department_id = sc.nextInt();
      sc.nextLine(); // Consume newline
      System.out.println("New Department Name: ");
      String name = sc.nextLine();

      String sql = "UPDATE Department SET name = '%s' WHERE department_id = %d";
      sql = String.format(sql, name, department_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
         System.out.println("Department name updated successfully.");
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }

   public static void updateAdministratorId(Statement stmt) {
      System.out.println("Admin ID: ");
      int admin_id = sc.nextInt();
      sc.nextLine(); // Consume newline
      System.out.println("New Admin ID: ");
      int newAdminId = sc.nextInt();

      String sql = "UPDATE Administration SET admin_id = %d WHERE admin_id = %d";
      sql = String.format(sql, newAdminId, admin_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
         System.out.println("Administrator ID updated successfully.");
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }

   public static void updateStudentAge(Statement stmt) {
      System.out.println("Student ID: ");
      int student_id = sc.nextInt();
      sc.nextLine(); // Consume newline
      System.out.println("New Age: ");
      int age = sc.nextInt();

      String sql = "UPDATE Students SET age = %d WHERE student_id = %d";
      sql = String.format(sql, age, student_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
         System.out.println("Student age updated successfully.");
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }

   public static void updateStaffExperience(Statement stmt) {
      System.out.println("Staff ID: ");
      int staff_id = sc.nextInt();
      sc.nextLine(); // Consume newline
      System.out.println("New Experience: ");
      int experience = sc.nextInt();

      String sql = "UPDATE Staff SET experience = %d WHERE staff_id = %d";
      sql = String.format(sql, experience, staff_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
         System.out.println("Staff experience updated successfully.");
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }


   //DElETE operations for each table

   public static void deleteProf(Statement stmt) {
      System.out.println("Prof ID: ");
      int prof_id = sc.nextInt();
      buffer = sc.nextLine();

      String sql = "DELETE FROM Prof WHERE prof_id = %d";
      sql = String.format(sql, prof_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      }

      catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Prof Deleted Successfully.");
      System.out.println();
   }

   public static void deleteStudent(Statement stmt) {
      System.out.println("Student ID: ");
      int student_id = sc.nextInt();
      buffer = sc.nextLine();

      String sql = "DELETE FROM Students WHERE student_id = %d";
      sql = String.format(sql, student_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Student Deleted Successfully.");
      System.out.println();
   }

   public static void deleteStaff(Statement stmt) {
      System.out.println("Staff ID: ");
      int staff_id = sc.nextInt();
      buffer = sc.nextLine();

      String sql = "DELETE FROM Staff WHERE staff_id = %d";
      sql = String.format(sql, staff_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Staff Deleted Successfully.");
      System.out.println();
   }

   public static void deleteDepartment(Statement stmt) {
      System.out.println("Department ID: ");
      int department_id = sc.nextInt();
      buffer = sc.nextLine();

      String sql = "DELETE FROM Department WHERE department_id = %d";
      sql = String.format(sql, department_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Department Deleted Successfully.");
      System.out.println();
   }

   public static void deleteAdministrator(Statement stmt) {
      System.out.println("Admin ID: ");
      int admin_id = sc.nextInt();
      buffer = sc.nextLine();

      String sql = "DELETE FROM Administration WHERE admin_id = %d";
      sql = String.format(sql, admin_id);

      try {
         stmt.executeUpdate(sql);
         conn.commit();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return;
      }

      System.out.println();
      System.out.println("Administrator Deleted Successfully.");
      System.out.println();

   }


   //Custom Operations for extra functionality

   public static void addNewDeptAndUpdateProfDept(Statement stmt) throws SQLException {  //adds a new department and changes a prof's dept id to that
      
         System.out.println("Department ID: ");
         int department_id = sc.nextInt();
         buffer = sc.nextLine();
         System.out.println("Department Name: ");
         String name = sc.nextLine();
         System.out.println("Department Location: ");
         String location = sc.nextLine();
         String sql1 = "INSERT INTO Department VALUES (%d, '%s', '%s')";
         sql1 = String.format(sql1, department_id, name, location);
         
          // Prompt user to enter the professor ID and update their department
          System.out.print("Enter the ID of the professor whose department to change: ");
          int profId = sc.nextInt();
          sc.nextLine(); // Consume newline
          String updateProfDeptID = "UPDATE Prof SET department_id = %d WHERE prof_id = %d";
          updateProfDeptID = String.format(updateProfDeptID, department_id, profId);
      
          stmt.executeUpdate(sql1);
          int rows = stmt.executeUpdate(updateProfDeptID);
          if(rows == 0){
            throw new SQLException();
          }
          conn.commit();
          System.out.println();
          System.out.println("New department added and professor's department updated successfully.");
          System.out.println();
      
  }   

   public static void showProfLocation(Statement stmt) { //shows dept locations of all profs
      try {
          String sql = "SELECT Prof.name AS ProfName, location FROM Prof, Department where Prof.department_id = Department.department_id";
          ResultSet rs = stmt.executeQuery(sql);
          System.out.println();
          while (rs.next()) {
              System.out.println("Professor Name: " + rs.getString("ProfName") +
                                 ", Department Location: " + rs.getString("location"));
          }
          System.out.println();
          rs.close();
      } catch (SQLException se) {
          System.out.println(se.getMessage());
          return;
      }
  }

   public static void showOldestInDept(Statement stmt) { //shows the oldest prof in a dept
      try {
         System.out.print("Enter the department_id: ");
         int d_number = sc.nextInt();
         buffer = sc.nextLine();
         String sql = "SELECT Prof.name as PName, Department.name as DName FROM Prof, Department WHERE Prof.department_id = %d AND Prof.department_id = Department.department_id AND age in (SELECT MAX(age) FROM Prof WHERE Prof.department_id = %d)";
         sql = String.format(sql, d_number, d_number);
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println();
         while (rs.next()) {
            System.out.println("Prof Name: " + rs.getString("PName")
                  + ", Dept Name: " + rs.getString("DName"));
         }
         System.out.println();
         rs.close();
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }

   public static void showProfsInDept(Statement stmt) {  //shows all profs in a department
      try { 
          System.out.print("Enter the department_id: ");
          int department_id = sc.nextInt();
          sc.nextLine(); // Consume newline
  
          String sql = "SELECT Prof.name AS ProfName FROM Prof WHERE Prof.department_id = %d";
          sql = String.format(sql, department_id);
  
          ResultSet rs = stmt.executeQuery(sql);
          System.out.println();
          while (rs.next()) {
              System.out.println("Professor Name: " + rs.getString("ProfName"));
          }
          System.out.println();
          rs.close();
      } catch (SQLException se) {
          System.out.println(se.getMessage());
          return;
      }
  }  

   public static void addProfasDean(Statement stmt) { //adds a new prof and assigns them as the Dean(should be done when dean already exists)

      System.out.println("Prof ID: ");
      int prof_id = sc.nextInt();
      buffer = sc.nextLine();
      System.out.println("Prof Name: ");
      String name = sc.nextLine();
      System.out.println("Prof Age: ");
      int age = sc.nextInt();
      buffer = sc.nextLine();
      System.out.println("Prof Department: ");
      String dept = sc.nextLine();
      String sql1 = "INSERT INTO Prof VALUES (%d, '%s', %d, '%s')";
      sql1 = String.format(sql1, prof_id, name, age, dept);

      String sql2 = "UPDATE Administration SET admin_id = %d WHERE position = 'Dean'";
      sql2 = String.format(sql2, prof_id);

      try {
         stmt.executeUpdate(sql1);
         stmt.executeUpdate(sql2);
         conn.commit();
         System.out.println("Prof added as administrator successfully.");
      } catch (SQLException se) {
         System.out.println(se.getMessage());
         return;
      }
   }

   // Set JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3306/companydb?useSSL=false";

   // Database credentials
   static final String USER = "root";// add your user
   static final String PASSWORD = "sqlPass#1234";// add password

   public static void main(String[] args) {
      Statement stmt = null;
      // STEP 2. Connecting to the Database
      try {
         // STEP 2a: Register JDBC driver
         Class.forName(JDBC_DRIVER);
         // STEP 2b: Open a connection
         // System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         conn.setAutoCommit(false);
         // STEP 2c: Execute a query
         // System.out.println("Creating statement...");
         stmt = conn.createStatement();
         useDB(stmt);
         displayMenu();
         command = sc.nextInt();
         buffer = sc.nextLine();
         while (command != 0) {  //repeatedly showing the menu and taking in command input from the user
            if (command == 1) {
               addProf(stmt);
            } else if (command == 2) {
               addDepartment(stmt);
            } else if (command == 3) {
               addAdministrator(stmt);
            } else if (command == 4) {
               addStudent(stmt);
            } else if (command == 5) {
               addStaff(stmt);
            } else if (command == 6) {
               showProfs(stmt);
            } else if (command == 7) {
               showDepartments(stmt);
            } else if (command == 8) {
               showAdministrators(stmt);
            } else if (command == 9) {
               showStudents(stmt);
            } else if (command == 10) {
               showStaff(stmt);
            } else if (command == 11) {
               deleteProf(stmt);
            } else if (command == 12) {
               deleteDepartment(stmt);
            } else if (command == 13) {
               deleteAdministrator(stmt);
            } else if (command == 14) {
               deleteStudent(stmt);
            } else if (command == 15) {
               deleteStaff(stmt);
            } else if (command == 16) {
               updateProfAge(stmt);
            } else if (command == 17) {
               updateDepartmentName(stmt);
            } else if (command == 18) {
               updateAdministratorId(stmt);
            } else if (command == 19) {
               updateStudentAge(stmt);
            } else if (command == 20) {
               updateStaffExperience(stmt);
            } else if (command == 21) {
               showOldestInDept(stmt);
            } else if (command == 22) {
               addProfasDean(stmt);
            }
            else if(command == 23){
               showProfsInDept(stmt);
            }
            else if(command == 24){
               showProfLocation(stmt);
            }
            else if(command == 25){
               addNewDeptAndUpdateProfDept(stmt);
            }
            else{
               System.out.println("Please enter one of the commands shown above: ");
               command = sc.nextInt();
               buffer = sc.nextLine();
               continue;
            }

            displayMenu();
            command = sc.nextInt();
            buffer = sc.nextLine();
         }

         stmt.close();
         conn.close();
      }
      catch (SQLException se) {  
         // Handle errors for JDBC
         se.printStackTrace();
         // If there is an error then rollback the changes.
         System.out.println("Rolling back data here....");
         try {
            if (conn != null)
               conn.rollback();
         } catch (SQLException se2) {
            System.out.println("Rollback failed....");
            se2.printStackTrace();
         }
      } catch (Exception e) {
         // Handle errors for Class.forName
         e.printStackTrace();
      } finally {
         // finally block used to close resources
         try {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2) {
         } // nothing we can do
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         } // end finally try
      }
   } // end main
} // end class
