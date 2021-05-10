package Aula3;

class ages {
    public static int getAge(char genre) {
        if (genre == 'm') {
            return 65;
        }
        return 60;
    }
}

public class Retirement04 {
    /**
     * o código esta meio grande estou testando algumas coisa.
     */
    public static void main(String[] args) {
        console.log("Informe sua idade: ");
        int age = console.readInt();
        console.log("Tempo de contribuição: ");
        int ageJob = console.readInt();
        console.log("Qual seu gênero: ");
        String genre = console.readString();
        String[] result = validRetirement(age, ageJob, genre.toLowerCase().charAt(0));
        console.clear();
        for (String res : result) {
            switch (res) {
                case "1":
                    console.log("Você já tem o direito a aposentadoria por Tempo de trabalho.");
                    break;
                case "2":
                    console.log("Você já tem o direito a aposentadoria por idade.");
                    break;
                default:
                    console.log(res);
            }
        }
    }

    public static String[] validRetirement(int age, int ageJob, char genre) {
        int ageLack = ages.getAge(genre) - age;
        int ageJobLack = ages.getAge(genre) - 30 - ageJob;
        String RetirementAgeJob = ageJobLack <= 0 ? "1"
                : "Você ainda não tem o direito de aposentadoria por tempo de trabalho falta " + ageJobLack + " anos.";
        String RetirementAge = ageLack <= 0 ? "2"
                : "Você ainda não tem o direito de aposentadoria por idade falta " + ageLack + " anos.";
        String[] arrayAge = { RetirementAge, RetirementAgeJob };
        return arrayAge;
    }
}