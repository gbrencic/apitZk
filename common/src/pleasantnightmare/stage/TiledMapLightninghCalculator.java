package pleasantnightmare.stage;

import org.newdawn.slick.geom.Line;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.09.29
 * Time: 08:33:46
 * To change this template use File | Settings | File Templates.
 */
public class TiledMapLightninghCalculator {
    private TiledStageMap stageMap;
    private Tile lightTile;
    private Line ray;   // koristiit ce za raycasting


    public TiledMapLightninghCalculator(TiledStageMap stageMap) {
        this.stageMap = stageMap;
    }

    public void calculateLight(int startY, int endY, int startX, int endX) {

        float illuminationStrenght = 0f;
        float lightDecay = 0f;   // izracunati iz Tilea
        //Temp
        int tx = 0;
        int txI;

        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                lightTile = stageMap.getTile(y, x);

                if (lightTile.lightCaster == true) {
                    illuminationStrenght = lightTile.getIlluminationStrenght();
                    lightDecay = illuminationStrenght / lightTile.getIlluminationRange();

                    //Podjela scjetla na okolne tilove
                    // Sto ako postoji drukciji tip svjetla kao bullseye ili neki ray
                    // treba definirati strategiju koja ce izracunavati svjetlo...
                    // ** Zasad ce ostati ovako for purposes of test.

                      /*
                        todo napraviti ray caster koji ce pregledati polja
                        naci algoritam za iztacun polja u spiralu
                         0                                -3
                      -1 0 +1
                   -2 -1 0 +1 +2
                -3 -2 -1 * +1 +2 +3               -3               3
                   -2 -1 0 +1 +2
                      -1 0 +1
                         0                                 3

                         pocni od polja goe ljevo pa do kraja pa dole pa ljevo pa gore
                         kad krenes gore povecaj broj u daljinu za 1
                         tako dobijemo kocku.

                         trebalo bi biti drugacije ... recimo da
                       - prvi red je LR
                       - sljedeci je LR -1 do 0

                     
                      */


                   


                    for (int l = 0; l > -10; l--) {
                        //todo ovo je previse loopova ...
                        //todo napraviti kalkulator u koji rucno upisemo vrijednost i on izracuna
                        tx = lightTile.getX() + l;
                        txI = lightTile.getX() - l;
                        if (tx < 0)
                            tx = 0;

                        //nemoj sebi
                        if (tx != lightTile.getX()) {
                            illuminationStrenght = illuminationStrenght - lightDecay;
                            stageMap.getTile(y, tx).setIlluminationStrenght(illuminationStrenght);
                            stageMap.getTile(y, txI).setIlluminationStrenght(illuminationStrenght);

                        }
                    }
                    /*for (int l = 2; l < 5; l++) {
                        for (int l2 = 2; l2 < 5; l2++) {

                            //          stageMap.getTile(y-l, x+l2).setOverlayColor(Color.gray.darker(darkness));

                        }
                        darkness = darkness + 0.1f;
                    }*/
                }
            }
        }
    }
}
