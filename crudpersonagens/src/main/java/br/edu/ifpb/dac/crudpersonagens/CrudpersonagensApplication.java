package br.edu.ifpb.dac.crudpersonagens;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.edu.ifpb.dac.crudpersonagens.controller.HabilidadeController;
import br.edu.ifpb.dac.crudpersonagens.controller.PersonagemController;
import br.edu.ifpb.dac.crudpersonagens.model.Habilidade;
import br.edu.ifpb.dac.crudpersonagens.model.Personagem;

@SpringBootApplication
public class CrudpersonagensApplication implements CommandLineRunner {
	
	@Autowired
	private PersonagemController personagemController;
	@Autowired
	private HabilidadeController habilidadeController;

	public static void main(String[] args) {
		SpringApplication.run(CrudpersonagensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("\n1 - Adicionar Personagem \n2 - Criar e adicionar habilidade num personagem "
				+ "\n3 - Listar todos os personagens \n4 - sair");
		int entrada = Integer.parseInt(leitor.nextLine());
		
		while(entrada != 4) {
			if(entrada == 1) {
				System.out.println("Insira os atributos do personagem ");
				System.out.println("Nome: ");
				String nome = leitor.nextLine();
				System.out.println("Classe: ");
				String classe = leitor.nextLine();
				System.out.println("Barra de Vida: ");
				int hp = Integer.parseInt(leitor.nextLine());
				
				personagemController.create(nome, classe, hp, null);
				
			}else if(entrada == 2) {
				System.out.println("Insira Habilidades: ");
				System.out.println("------------------- ");
				System.out.println("Insira o nome da habilidade: ");
				String nomeSkill = leitor.nextLine();
				System.out.println("Cooldown: ");
				int cooldown = Integer.parseInt(leitor.nextLine());
				System.out.println("Descrição: ");
				String descricao = leitor.nextLine();
				System.out.println("Dano: ");
				int dano = Integer.parseInt(leitor.nextLine());
				habilidadeController.create(nomeSkill, cooldown, descricao, dano);
				List<Habilidade> habilidades = habilidadeController.listAll();
				List<Personagem> Personagens = personagemController.listAll();
				System.out.println("Nome do personagem para adicionar a habilidade");
				String nome = leitor.nextLine();
				
				Habilidade habilidadeAdicionada = habilidades.get(habilidades.size()-1);
				
				for (Personagem personagem : Personagens) {
					if(personagem.getNome().equals(nome)) {
						List<Habilidade> habilidadesDoPersonagem = personagem.getHabilidades();
						habilidadesDoPersonagem.add(habilidadeAdicionada);
						personagem.setHabilidades(habilidadesDoPersonagem);
						personagemController.update(personagem);
					}
				}
				
			}else if(entrada == 3){
				List<Personagem> Personagens = personagemController.listAll();
				for (Personagem personagem : Personagens) {
					System.out.println(personagem.toString());
					System.out.println("-----------------------------------------------");
				}
			}
			System.out.println("\n1 - Adicionar Personagem \n2 - Criar e adicionar habilidade num personagem"
					+ "\n3 - Listar todos os personagens \n4 - sair");
			entrada = Integer.parseInt(leitor.nextLine());
		}
		
		leitor.close();
	}

}
