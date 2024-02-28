class  Student {
    String fio;
    String numGroup;
    int[] progress;

    Student(String fio, String numGroup, int[] progress) {
        this.fio = fio;
        this.numGroup = numGroup;
        this.progress = progress;
    }

    public void displayInfo() {
        System.out.print("ФИО: " + fio + " Номер группы: " + numGroup + " Успеваемость: ");
        for (int x : progress) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }

    public double averageMark() {
        double sum = 0;
        for (int x : progress) {
            sum += x;
        }
        return sum / progress.length;
    }

    public boolean progressCheck() {
        for (int x : progress) {
            if (x != 4 && x != 5) return false;
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {

        Student[] students = new Student[10];

        int[] progress0 = {5, 4, 5, 4, 4};
        students[0] = new Student("Иванов И.И.", "22ИТ17", progress0);

        int[] progress1 = {5, 5, 5, 5, 5};
        students[1] = new Student("Петров П.П.", "22ИТ15", progress1);

        int[] progress2 = {3, 4, 4, 5, 5};
        students[2] = new Student("Сидоров С.С.", "23ИТ21", progress2);

        int[] progress3 = {5, 5, 4, 4, 5};
        students[3] = new Student("Козлов А.В.", "22ПТ17", progress3);

        int[] progress4 = {4, 5, 5, 3, 4};
        students[4] = new Student("Никитин В.А.", "20ИТ11", progress4);

        int[] progress5 = {3, 3, 4, 2, 5};
        students[5] = new Student("Белов Д.М.", "21ИТ120", progress5);

        int[] progress6 = {4, 4, 5, 3, 5};
        students[6] = new Student("Морозов Е.С.", "23ПТ125", progress6);

        int[] progress7 = {5, 5, 5, 4, 4};
        students[7] = new Student("Алексеев К.В.", "22ИТ17", progress7);

        int[] progress8 = {3, 4, 3, 5, 4};
        students[8] = new Student("Григорьев П.С.", "22ИТ26", progress8);

        int[] progress9 = {4, 3, 4, 5, 3};
        students[9] = new Student("Дмитриев И.В.", "21ИТ18", progress9);

        System.out.println("Список студентов по возрастанию среднего балла: ");

            for (int i = 0; i < students.length - 1; i++) { //проход по  строкам
                for (int k = 0; k < students.length - i - 1; k++) { //проход по неотсортированному массиву
                    if (students[k].averageMark() > students[k + 1].averageMark()) { //замена элементов, если следуюий элемент больше предыдущего
                        Student temp = students[k];
                        students[k] = students[k + 1];
                        students[k + 1] = temp;
                    }
                }
            }
        for (Student student : students) {
            student.displayInfo();
        }

        System.out.println("Список студентов, оценки которых не меньше 4:");
        for (Student student : students){
            if(student.progressCheck()) student.displayInfo();
        }
    }
}