package examples;

class Voter {
    private String name;
    private String voterId;
    private boolean hasVoted;

    
    public Voter(String name, String voterId) {
        this.name = name;
        this.voterId = voterId;
        this.hasVoted = false;
    }

    
    public String getName() {
        return name;
    }

    
    public String getVoterId() {
        return voterId;
    }

    
    public void castVote() {
        if (!hasVoted) {
            hasVoted = true;
            System.out.println(name + " has successfully voted.");
        } else {
            System.out.println("Vote already cast. Multiple votes not allowed.");
        }
    }

    
    public boolean getVotingStatus() {
        return hasVoted;
    }

    
    public void displayInfo() {
        System.out.println("Voter Name: " + name);
        System.out.println("Voter ID: " + voterId);
    }
}
