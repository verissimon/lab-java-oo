import dominio.*;


public class Main {
    public static void main(String[] args) {
        Course oopCourse = new Course();
        oopCourse.setTitle("java poo");
        oopCourse.setDescription("curso intermediario orientacao a objetos em java.");
        oopCourse.setWorkloadHours(10);

        Course basicCourse = new Course();
        basicCourse.setTitle("java basico");
        basicCourse.setDescription("curso java com conceitos basicos da linguagem.");
        basicCourse.setWorkloadHours(6);

        Mentoring javaMentoring = new Mentoring();
        javaMentoring.setTitle("java ");
        javaMentoring.setDescription("mentoria para curso de java");

        Bootcamp javaBootcamp = new Bootcamp();
        javaBootcamp.setName("Bootcamp java");
        javaBootcamp.setDescription("Bootcamp java basico e orientação a objetos.");
        javaBootcamp.getContents().add(basicCourse);
        javaBootcamp.getContents().add(javaMentoring);
        javaBootcamp.getContents().add(oopCourse);

        String[] studentNames = {"fulano", "ciclano", "Nabucodonosor"};
        for (String studentName : studentNames) {
            Dev dev = new Dev();
            dev.setName(studentName);
            dev.subscribeToBootcamp(javaBootcamp);
            dev.showSubscribedContent();
            dev.progress();
            dev.progress();
            dev.progress();
            dev.showSubscribedContent();
            dev.showFinishedContent();
            System.out.println("Experience acquired: " + dev.calculateTotalExp());
        }

    }
}