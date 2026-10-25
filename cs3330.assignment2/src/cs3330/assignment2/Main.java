package cs3330.assignment2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------TEST--------\n");

        Technician tech1 = new Technician("Anna Markway");
        Technician tech2 = new Technician("Arjun Garikapaty");
        Technician tech3 = new Technician("Anna Markway");

        Set<Technician> techSet = new HashSet<>();
        techSet.add(tech1);
        techSet.add(tech2);
        techSet.add(tech3);

        System.out.println("Total technicians added to HashSet: 3");
        System.out.println("Actual unique technicians in HashSet: " + techSet.size());
        for (Technician t : techSet) {
            System.out.println(t);
        }
        System.out.println();


        HelpDesk helpDesk = new HelpDesk();

        SupportRequest req1 = new PasswordResetRequest(101, "Canvas Issue", 10, "junebug");
        SupportRequest req2 = new PasswordResetRequest(102, "Email Lockout", 15, "prof_milyo");

        SupportRequest req3 = new DeviceSetupRequest(201, "Computer Setup", 20, 4);
        SupportRequest req4 = new DeviceSetupRequest(202, "Laptop Config", 25, 1);

        SupportRequest req5 = new NetworkIssueRequest(301, "Library Wi-Fi Disconnected", 30, 25); 
        SupportRequest req6 = new NetworkIssueRequest(302, "Dorm Ethernet Port Broke", 20, 5); 

        helpDesk.addRequest(req1);
        helpDesk.addRequest(req2);
        helpDesk.addRequest(req3);
        helpDesk.addRequest(req4);
        helpDesk.addRequest(req5);
        helpDesk.addRequest(req6);

        System.out.println("2. ALL REGISTERED REQUESTS");
        helpDesk.printAllRequests();
        System.out.println();

        System.out.println("3. ASSIGNING REQUESTS ");
        helpDesk.assignRequest(tech1, 101);
        helpDesk.assignRequest(tech1, 201);
        helpDesk.assignRequest(tech2, 202);
        helpDesk.assignRequest(tech2, 301);
        System.out.println("Assigned requests 101 and 201 to " + tech1);
        System.out.println("Assigned requests 202 and 301 to " + tech2);
        System.out.println();

        System.out.println("4. TECHNICIAN ASSIGNMENTS BEFORE RESOLVED ");
        helpDesk.printAssignmentsFor(tech1);
        System.out.println();
        helpDesk.printAssignmentsFor(tech2);
        System.out.println();

        System.out.println("5. RESOLVING REQUESTS ");
        int pts1 = helpDesk.resolveRequest(tech1, 101); 
        System.out.println("Resolved Request 101 for Anna Markway. Points awarded: " + pts1);

        int pts2 = helpDesk.resolveRequest(tech1, 201); 
        System.out.println("Resolved Request 201 for Anna Markway. Points awarded: " + pts2);

        int pts3 = helpDesk.resolveRequest(tech2, 301); 
        System.out.println("Resolved Request 301 for Arjun Garikapaty. Points awarded: " + pts3);
        System.out.println();

        System.out.println("6. ALL REQUESTS AFTER RESOLUTION ");
        helpDesk.printAllRequests();
        System.out.println();


        System.out.println("7. DEMONSTRATING HELPDESKUTIL METHODS ");
        List<Technician> techList = new ArrayList<>();
        techList.add(tech1);
        techList.add(tech2);

        System.out.println("Printing active technicians:");
        HelpDeskUtil.printAll(techList);
        System.out.println();

        int grandTotalPoints = HelpDeskUtil.sumPoints(techList);
        System.out.println("Total points across all technicians: " + grandTotalPoints);
        System.out.println();

        System.out.println("8. DEMONSTRATING VALIDATION");

        try {
            helpDesk.addRequest(new PasswordResetRequest(101, "Duplicate Test", 10, "user123"));
            System.out.println("ERROR: Duplicate was not caught!");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected IllegalArgumentException: " + e.getMessage());
        }

        try {
            helpDesk.resolveRequest(tech1, 101);
            System.out.println("ERROR: Duplicate resolution was not caught!");
        } catch (IllegalStateException e) {
            System.out.println("Caught expected IllegalStateException: " + e.getMessage());
        }

        try {
            new Technician("   ");
            System.out.println("ERROR: Blank name was not caught!");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected IllegalArgumentException: " + e.getMessage());
        }

    }
}