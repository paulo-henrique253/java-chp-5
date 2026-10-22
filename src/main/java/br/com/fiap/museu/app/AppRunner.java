package br.com.fiap.museu.app;

import br.com.fiap.museu.model.Obra;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppRunner implements CommandLineRunner {

    private static List<Obra> obras;

    @Override
    public void run(String... args) throws Exception {

    }
}
