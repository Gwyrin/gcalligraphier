/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcalligraphier.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author Vincent
 */
public class WrkIO {
   
    public boolean writeTextFile( String filepath, ArrayList<String> linesToWrite ) {

        boolean resultat = false;

        if ( linesToWrite != null ) {    // S'il n'y a rien à faire on ne fait rien (pas même effacer le fichier) !

            BufferedWriter bw = null;

            try {
                // L'ancien fichier sera remplacé par le nouveau contenu, même si vide
                bw = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream( filepath, false ), "UTF8" ) );

                for ( String ligne : linesToWrite ) {
                    if ( ligne != null ) {
                        bw.write( ligne );
                        bw.newLine();
                    }
                }

                bw.flush();
                bw.close();
                bw = null;

                resultat = true;    // Si on est ici c'est que tout roule !
            }
            catch ( Exception e ) {
            }
            finally {
                // Toujours fermer le fichier si pas déjà fait !
                if ( bw != null ) {
                    try {
                        bw.close();
                        bw = null;
                    }
                    catch ( IOException ioe2 ) {
                        // On peut l'ignorer, le cas est déjà traité
                    }
                }

                // Si l'écriture a échoué d'une façon où d'une autre, ne pas laisser un fichier incomplet
                if ( !resultat ) {
                    try {
                        new File( filepath ).delete();
                    }
                    catch ( Exception e ) {
                    }
                }
            }
        }

        return resultat;
    }

}
