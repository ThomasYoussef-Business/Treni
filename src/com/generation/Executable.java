package com.generation;

import com.generation.businesslogic.RoutesBusinessLogic;
import com.generation.library.ConsoleV2;

public class Executable
{
	public static void main(String[] args)
	{
		RoutesBusinessLogic rbl = new RoutesBusinessLogic();

		String cmd;

		do
		{
			System.out.println("Inserisci comando");
			cmd = ConsoleV2.readString().toLowerCase();

			switch (cmd)
			{
				case "print"            -> rbl.printAll();
				case "new"            	-> rbl.createNewRoutes();
				case "print-from"        -> rbl.printFrom();
				case "help"            	-> help();
				case "quit"            	-> System.out.println("BYE BYE");
				default                	-> System.out.println("Comando non valido");
			}


		}while (!cmd.equals("quit"));
	}

	private static void help()
	{
        String prompt = """
                Comandi disponibili
                print - stampa tutte le routes
                print-from - stampa tutte le routes che partono da una stazione
                new - crea nuova route
                quit - esci""";

		System.out.println(prompt);
	}
}
