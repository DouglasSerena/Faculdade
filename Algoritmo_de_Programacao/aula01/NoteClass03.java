package Aula3;

public class NoteClass03 {
    /**
     * OBJ: não a como usar o JOptionPane, pois estou usando o docker e ele não
     * possui interfase gráfica.
     */
    public static void main(String[] args) {
        float noteProofOne;
        float noteProofTwe;
        float noteJob;
        do {
            console.log("Informe as notas da primeira prova e a segunda: ");
            noteProofOne = console.readFloat();
            noteProofTwe = console.readFloat();
        } while (isValidNote(noteProofOne, "Nota da prova um esta fora do padrão.")
                || isValidNote(noteProofTwe, "Nota da prova um esta fora do padrão."));
        do {
            console.log("Informe as nota do trabalho: ");
            noteJob = console.readFloat();
        } while (isValidNote(noteJob, "Nota do trabalho esta fora do padrão."));

        float med = (noteJob + noteProofOne + noteProofTwe) / 3;
        console.clear();
        String result = med >= 6 ? "Aprovado" : "Reprovado";
        console.log(String.format("A media deste aulo ficou %.2f (%s).", med, result));

    }

    private static boolean isValidNote(float note, String caseFailed) {
        if (note < 0 || note > 10) {
            console.log(String.format(caseFailed));
            return true;
        } else {
            return false;
        }
    }
}