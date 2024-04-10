import java.util.Scanner;
/**
 *
 * ApplicationTree uses a Tree Data Structure to categorize High-school students, Pre-CS students and CS students
 * User input will determine which category they full under which will lead them to questions which a Binary Tree Data Structure was used for
 *
 **/

public class ApplicationTree {
    private TreeNode root;
    private String status;


    //default constructor
    public ApplicationTree(){
        this.root = null;

    }
    //constructor with specified data as root
    public ApplicationTree(String data) {
        this.root = new TreeNode (data);
        this.status = "";

    }
    //constructor with two subtrees
    public ApplicationTree(String data, ApplicationTree left, ApplicationTree right) {

        this.root = new TreeNode(data);
        //if left root is null, set left root.left to root of left
        root.left = (left != null) ? left.root : null;
        //if right is null, set root.right to root of right node
        root.right = (right != null) ? right.root : null;
    }
    //if root is null, return null else return root
    public String getData(){
        return root != null ? root.data : null;
    }
    //sets the enrollment status of the student
    private void setStatus(String status){
        this.status = status;
    }
    //returns enrollment status
    public String updatedStatus() {
        return status;
    }

    //traverse through questions for high-school students
    public void traverseTree(int score) {
        traverseTree(root,score);
    }
    private void traverseTree(TreeNode current, int score){
        determineStatus(current, score);

    }
    //this method will determine if the student is eligble to apply
    private void determineStatus(TreeNode current, int score){
        System.out.println("Application for Sac State: Computer Science");
        Scanner scan = new Scanner(System.in);
        String input;
        while (current.left != null || current.right != null) {
            System.out.println(current.data);
            input = scan.nextLine().trim();

            if (input.equalsIgnoreCase("No")||input.equalsIgnoreCase("NA")) {
                current = current.right;

            } else {
                current = current.right;
                score += 10;
            }
        }

        // Print the data of the last node
        System.out.println(current.data);
        //input of Aleks score will determine what score to give user
        input = scan.nextLine().trim();
        try{
            int num = Integer.parseInt(input);
            if(num >= 53){
                score += 10;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid score");
        }
        //a score above 50 is accepted, anything less will prompt user to wait for admission results
        if(score > 50){
            String s = "Congratulations, you will be admitted once we confirm the information provided. Please declare your entent to enroll by the end of June in your"
                    + " Sac State student center";
            System.out.println(s);
            this.setStatus("Applicant accepted. Review transcripts");
        } else {
            String s = "Thank you for applying for Sac State's Computer Science program, we will determine admission results by the end of July";
            System.out.println(s);
            this.setStatus("Pending, review applicant's transcripts");
        }

    }
    //traverse through questions for current college students
    public void traverseCSTree(double gpa) {
        traverseCSTree(root,gpa);
    }
    //prompts user wether they are applying for pre-cs major or cs
    private void traverseCSTree(TreeNode current,double gpa){
        if(current == null){
            return;
        }
        status = "";
        Boolean requirements_met = true;
        System.out.println(current.data);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim();
        if(input.substring(0,1).equalsIgnoreCase("p")){

            System.out.println("Pre-Computer Science Application:");
            current = current.left;
            System.out.println(current.data);
            input = scan.nextLine().trim();
            if(input.equalsIgnoreCase("yes")  && gpa >= 2.5){
                current = current.right;
                this.setStatus("Requirements met for Pre-Computer Science, review applicant's transcripts");
            } else {
                current = current.left;
                this.setStatus("GPA or course requirements not met");
            }
            System.out.println(current.data);

        } else {
            System.out.println("Computer Science Application:");
            System.out.println("Please enter the grade received in CSC15 or equivalent: \nEnter NA if you have not taken the course" );
            while (current.left != null || current.right != null) {
                input = scan.nextLine().trim();
                if (input.equalsIgnoreCase("NA") || input.equalsIgnoreCase("D") || input.equalsIgnoreCase("F")) {
                    current = current.left;
                    this.setStatus("GPA or course requirements not met");
                    requirements_met = false;
                } else {
                    current = current.right;

                }
                System.out.println(current.data);
                if(requirements_met) {
                    if(gpa > 3.5)
                        this.setStatus("Applicant accepted. Review transcripts");
                    else
                        this.setStatus("Minimum requirements met for Computer Science. Review transcripts");
                } else {
                    this.setStatus("GPA or course requirements not met");
                }

            }
        }
    }

    class TreeNode {
        private String data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode (String data) {
            this.data = data;
            left = null;
            right = null;
        }


    }
}

