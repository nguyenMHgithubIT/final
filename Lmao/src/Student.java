class Student {
    private int id;
    private String name;
    private double marks; // Assuming marks is a double for more precision

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;

    }

    // Mảng tĩnh để lưu giới hạn điểm và xếp hạng
    private static final double[] MARK_RANGES = {5.0, 6.5, 7.5, 9.0};
    private static final String[] RANKINGS = {"Fail", "Medium", "Good", "Very Good", "Excellent"};



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Phương thức trả về xếp hạng dựa trên điểm
    public String getRanking() {
        for (int i = 0; i < MARK_RANGES.length; i++) {
            if (marks < MARK_RANGES[i]) {
                return RANKINGS[i];
            }
        }
        return RANKINGS[RANKINGS.length - 1]; // Trả về "Excellent" nếu điểm >= 9.0
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

