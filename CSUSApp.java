
/**
 *
 * This class stores the questions and answers for the CSUS Computer Science application
 *
 */


public class CSUSApp {
    private ApplicationTree tree;


    public CSUSApp(){


    }
    //this method determines which branch to traverse through
    public void traverseTree(double gpa, boolean collegeApplicant) {
        if(collegeApplicant) {
            fillCollegeTree(gpa);
            tree.traverseCSTree(gpa);
        } else {
            fillTree();
            tree.traverseTree(gpaScore(gpa));
        }
    }

    public void fillCollegeTree(double gpa){
        //stores questions in the array q
        String[] q = {
                "Are you applying for pre-Computer Science or Computer Science?",
                "Have you taken and passed Math 30 or equivalent?",
                "Please enter the grade received in CSC20 or equivalent: \nEnter NA if you have not taken the course ",
                "Please enter the grade received in CSC28 or equivalent: \nEnter NA if you have not taken the course ",
                "Please enter the grade received in CSC35 or equivalent: \nEnter NA if you have not taken the course ",
                "Please enter the grade received in Math 30 or equivalent: \nEnter NA if you have not taken the course ",
                "Please enter the grade received in Math 31 or equivalent: \nEnter NA if you have not taken the course ",
                "Please enter the grade received in Phys 11A or equivalent: \nEnter NA if you have not taken the course ",
        };
        //stores answers in an the array a, answers represent the leaf node in the tree
        String[] a = {
                "Applying for pre-Computer Science requires an overall GPA of at least 2.5 and/or the completion of Math 30",
                "Thank you for applying for pre-Computer Science. Your admission status will be updated in your Sac State student center after we confirm the "
                        + "information provided",
                "Sorry, this application requires the completion and passing of this course",

        };
        String a3 = "";
        if(gpa >= 3.5){
            a3 = "Congratulations!After we confirm the information provided, you will be admitted to Sac State's Computer Science program, please"
                    + "refer to your Sac State student center for admission details";
        } else if(gpa >= 2.7){
            a3 = "Thank you for applying for Sac State's Computer Science program. Please refer to your Sac State student center"
                    + "for details on your application";
        } else {
            a3 = "Unfortunately, a gpa of at least 2.7 is required to apply for Sac State's Computer Science program";
        }
        ApplicationTree c2,c3,c4,c5,c6,c7,c10,c13,c16,c19,c22;
        c2 = new ApplicationTree(a[0]);
        c3 = new ApplicationTree(a[1]);
        c4  = new ApplicationTree(q[1],c2,c3);

        c5 = new ApplicationTree(a[2]);
        c6 = new ApplicationTree(a3);
        c7 = new ApplicationTree(q[7], c5,c6);

        c10 = new ApplicationTree(q[6],c5,c7);
        c13 = new ApplicationTree(q[5],c5,c10);
        c16 = new ApplicationTree(q[4],c5,c13);
        c19 = new ApplicationTree(q[3],c5,c16);
        c22 = new ApplicationTree(q[2],c5,c19);

        tree = new ApplicationTree(q[0],c4,c22);

    }

    private int gpaScore(double gpa){
        int score = 0;
        if (gpa > 3.5) {
            score += 20;
        } else if (gpa > 3.0) {
            score += 10;
        }  else if (gpa > 2.5) {
            score += 5;
        }
        return score;
    }

    public String updateStatus(){
        return tree.updatedStatus();
    }
    public void fillTree(){

        String[] q = {
                "Have you taken/passed Pre-Calculus?",
                "Did you submit any recommendation letters on calstate.edu?",
                "List any club/organizations/sports you are/were involved in. Enter \"na\" if none",
                "Please enter your Aleks score",
        };
        ApplicationTree c4,c5,c6;

        c4 = new ApplicationTree(q[3]);
        c5 = new ApplicationTree(q[2],c4,c4);
        c6 = new ApplicationTree(q[1],c5,c5);

        tree = new ApplicationTree(q[0],c6,c6);
    }
}
