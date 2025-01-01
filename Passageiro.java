public class Passageiro {
    private String id;
    private int idade;

    public Passageiro(String id, int idade) {
        this.id = id;
        this.idade = idade;
    }
    public String getId() {
        return id;
    }
    public int getIdade() {
        return idade;
    }
    public boolean isPreferencial(){
        if (idade >= 65){
            return true;
        }return false;
    }
    public String toString() {
        return id;
    }
}
