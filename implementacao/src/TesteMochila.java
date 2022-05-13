import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
// import org.junit.platform.commons.logging.*;

public class TesteMochila {
    private Logger logger = Logger.getLogger(TesteMochila.class.getName());
    private FileHandler handler;

    public TesteMochila() throws Exception{
        this.handler = new FileHandler("mochila.log", true);
        logger.addHandler(this.handler);
    }

    @BeforeClass
    public void mudaCaminhoLog(){
        System.setProperty("java.util.logging.config.file", ClassLoader.getSystemResource("logging.properties").getPath());
    }

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        logger.info(() -> String.format("About to execute repetition %d of %d for %s", currentRepetition, totalRepetitions, methodName));
    }
    
    // @RepeatedTest(100)
    @RepeatedTest(100)
    public void testaSolucaoMochila(){
        int quantidadeItens = 22; // quantidade encontrada de 4 segundos
        
        // gera itens da mochila            
        int capacidade = (quantidadeItens * 3) + 1;
        ItemMochila[] test = Main.geradorItens(capacidade, quantidadeItens);
        // System.out.println("Itens: ");
        
        // for ( ItemMochila it : test ) {
        //     System.out.println(it.toString());
        // }
        
        // forca bruta
        ForcaBruta fb = new ForcaBruta();
        Mochila solucaoBruta = fb.forcaBruta(test, capacidade);
        System.out.println("Solucao forca bruta: "+solucaoBruta.toString());
        
        // guloso
        Guloso g = new Guloso();
        Mochila solucaoGulosa = g.guloso(test, capacidade);
        System.out.println("Solucao Guloso: "+solucaoGulosa.toString());
        
        if(solucaoBruta.getPesoTotal() == solucaoGulosa.getPesoTotal() && solucaoBruta.getValorTotal() == solucaoGulosa.getValorTotal()){
            System.out.println("Teste finalizado com SUCESSO.");
        } else System.out.println("Teste finalizado com FALHA.");

        validaRetornoSolucoes(solucaoBruta, solucaoGulosa);
        // }
        // System.exit(0);
    }

    public void validaRetornoSolucoes(Mochila forcaBruta, Mochila guloso){
        assertEquals(forcaBruta.getPesoTotal(), guloso.getPesoTotal());
        assertEquals(forcaBruta.getValorTotal(), guloso.getValorTotal());
    }

}
