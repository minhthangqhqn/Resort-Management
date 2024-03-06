package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Validation {
    //Define regex for employee ID format: EMP-YYYY (YYYY is digit from 0-9)
    private final String EMPID_REGEX = "^EMP-[0-9]{4}$";
    //Define regex for customer ID format: EMP-YYYY (YYYY is digit from 0-9)
    private final String CUSID_REGEX = "^CUS-[0-9]{4}$";
    //Define regex for person name that uppercase first character of each word
    private final String NAME_REGEX = "^[A-Z][a-z]*(\\\\s[A-Z][a-z]*)*$";
    // Define regex for citizen identification number have 12 digits
    private final String IDENTIFICATION_REGEX = "^\\d{9}(\\d{3})?$";
    // Define regex for phone number have 10 digits and start with 0
    private final String PHONE_REGEX = "^0\\d{9}$";
    private final String stringRegex = "[a-zA-Z]+";
    private final String doubleRegex = ".*\\d+.*";
    private final String intRegex = ".*\\d+.*";
    private final String whiteSpace = ".*\\s.*";
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public String getValue(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine().trim();
    }

    //valid Employee ID
    public String getAndValidEmployeeId(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(EMPID_REGEX)){
                    System.out.println("Invalid Employee ID, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //valid String
    public String getAndValidString(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(stringRegex)){
                    System.out.println("Invalid input, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //valid Double
    public String getAndValidDouble(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(doubleRegex)){
                    System.out.println("Invalid input, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //valid int
    public String getAndValidInt(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(intRegex)){
                    System.out.println("Invalid input, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //valid name
    public String getAndCheckName(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(stringRegex) && !input.matches(whiteSpace)){
                    System.out.println("Invalid name, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //valid salary
    public double getAndValidSalary(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                double salary = Double.parseDouble(input);
                if(!input.matches(doubleRegex)){
                    System.out.println("Invalid input, please type again!");
                    continue;
                }
                else if(salary <= 0){
                    System.out.println("Salary must be greater than 0!");
                    continue;
                }
                return salary;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    //valid date dd/mm/yyyy
    public Date getAndCheckDate(String msg){
        String input;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false); // ensure that the input strict validation.
        while (true){
            try{
                input = getValue(msg);
                Date date = sdf.parse(input);
                if(!validateDateAndMonth(date)){
                    System.out.println("Invalid date, please input again");
                    continue;
                }
                else if(!checkIfValidAge(date)){
                    System.out.println("Your age must be greater than 18!");
                    continue;
                }
                return date;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public boolean validateDateAndMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return (month >= 1 && month <= 12) && (day >= 1 && day <= cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    //check valid age
    public boolean checkIfValidAge(Date birthDate){
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - birthDate.getYear();
        return age >= 18;
    }

    //valid gender
    public String getAndValidGender(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.equalsIgnoreCase("Male") && !input.equalsIgnoreCase("Female")){
                    System.out.println("Invalid gender, please type again");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //valid identity
    public String getAndValidIdentity(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(IDENTIFICATION_REGEX)){
                    System.out.println("Invalid identification, citizen identification number must have 12 digits!");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //valid phone number
    public String getAndValidPhoneNumber(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(PHONE_REGEX)){
                    System.out.println("Invalid phone number, phone number must have 10 digits and must start with 0");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //valid email
    public String getAndValidEmail(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                String[] stringParts = input.split("@");
                if(stringParts.length == 0){
                    System.out.println("Email can not empty!");
                    continue;
                }
                String accountName = stringParts[0];
                String domain = stringParts[1];
                if(!accountName.matches(stringRegex) && !domain.equalsIgnoreCase("gmail.com")){
                    System.out.println("Invalid email, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //valid qualifications
    public String getAndValidQualification(String msg){
        String input;
        Set<String> validQualification = new HashSet<>(Set.of("Intermediate", "University", "College", "Postgraduate"));
        while(true){
            try{
                input = getValue(msg);
                if(!validQualification.contains(input)){
                    System.out.println("Invalid qualification, please type again");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //valid level
    public String getAndValidLevel(String msg){
        String input;
        Set<String> validLevel = new HashSet<>(Set.of("Receptionist", "Supervisor", "Auditor", "Waiter", "HR Manager", ",F&B Manager"));
        while(true){
            try{
                input = getValue(msg);
                if(!validLevel.contains(input)){
                    System.out.println("Invalid qualification, please type again");
                    continue;
                }
                return input;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    //check valid choice
    public String getAndValidChoice(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")){
                    System.out.println("Invalid choice, please input again!");
                    continue;
                }
                break;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return input;
    }
}
