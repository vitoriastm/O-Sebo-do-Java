package projeto.sistema.arquivos;

public class DiretorioArquivos {
    private String workingDir;
    
    public DiretorioArquivos() {
        this.workingDir = (System.getProperty("user.dir"));
    }
    public static String getDir() {
        return (System.getProperty("user.dir"));
    }
    public static void main(String[] args) {
        System.out.println("Working Directory = " + (System.getProperty("user.dir")));
    }
    
}
