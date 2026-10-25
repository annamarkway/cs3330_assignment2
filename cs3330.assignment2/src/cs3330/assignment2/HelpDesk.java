package cs3330.assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HelpDesk {
	
	private final Map<Integer, SupportRequest> requestsById;
    private final Map<Technician, List<SupportRequest>> assignments;

    public HelpDesk() {
        this.requestsById = new HashMap<>();
        this.assignments = new HashMap<>();
    }
    
    public void addRequest(SupportRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Support request cannot be null.");
        }
        int id = request.getId();
        if (requestsById.containsKey(id)) {
            throw new IllegalArgumentException("Request with ID " + id + " already exists.");
        }
        requestsById.put(id, request);
    }
    
    public SupportRequest findRequest(int id) {
        return requestsById.get(id);
    }
    
    public void assignRequest(Technician technician, int requestId) {
        if (technician == null) {
            throw new IllegalArgumentException("Technician cannot be null.");
        }

        SupportRequest request = findRequest(requestId);
        if (request == null) {
            throw new IllegalArgumentException("Request ID " + requestId + " does not exist.");
        }

        if (request.isResolved()) {
            throw new IllegalStateException("Request ID " + requestId + " is already resolved and cannot be assigned.");
        }
        
    
    
    
    
    for (Map.Entry<Technician, List<SupportRequest>> entry : assignments.entrySet()) {
        for (SupportRequest assigned : entry.getValue()) {
            if (assigned.getId() == requestId) {
                if (entry.getKey().equals(technician)) {
                    throw new IllegalStateException(
                        "Request ID " + requestId + " is already assigned to " + technician
                    );
                } else {
                    throw new IllegalStateException(
                        "Request ID " + requestId + " is already assigned to another technician."
                    );
                }
            }
        }
    }
    List<SupportRequest> techAssignments = assignments.get(technician);
    if (techAssignments == null) {
        techAssignments = new ArrayList<>();
        assignments.put(technician, techAssignments);
    }

    techAssignments.add(request);
    
    
    }
    
    
    public int resolveRequest(Technician technician, int requestId) {
        if (technician == null) {
            throw new IllegalArgumentException("Technician cannot be null.");
        }

        List<SupportRequest> techAssignments = assignments.get(technician);
        if (techAssignments == null) {
            throw new IllegalStateException("No requests are assigned to technician: " + technician);
        }

        SupportRequest targetRequest = null;
        for (SupportRequest req : techAssignments) {
            if (req.getId() == requestId) {
                targetRequest = req;
                break;
            }
        }

        if (targetRequest == null) {
            throw new IllegalArgumentException(
                "Request ID " + requestId + " is not assigned to technician: " + technician
            );
        }

        
        return targetRequest.resolveFor(technician);
    }
    
    public void printAllRequests() {
        System.out.println("All Support Requests");
        if (requestsById.isEmpty()) {
            System.out.println("No requests registered.");
            return;
        }
        for (SupportRequest request : requestsById.values()) {
            System.out.println(request);
        }
    }
    
    public void printAssignmentsFor(Technician technician) {
        if (technician == null) {
            throw new IllegalArgumentException("Technician cannot be null.");
        }

        System.out.println("Assignments for " + technician);
        List<SupportRequest> techAssignments = assignments.get(technician);
        if (techAssignments == null || techAssignments.isEmpty()) {
            System.out.println("No requests assigned.");
            return;
        }
        for (SupportRequest request : techAssignments) {
            System.out.println(request);
        }
    }
    }





    
