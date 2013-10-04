package pleasantnightmare.stage;


/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.09.28
 * Time: 13:32:43
 * To change this template use File | Settings | File Templates.
 */
public class Tile {
    //Position on the map
    private int x;
    private int y;

    private boolean visited = false;

    // private Image tileGraphic;       //Dodati animaciju?
    private int tileImageID = 0;

    private boolean blockMovement = false;
    private boolean blockJump = false;
    private boolean blockLOS = false;
    private boolean blockLight = false;

    //Pathfinding move cost, lower is easier to walk
    private byte movementCost = 0;

    //How mutchLight is cast on the tile by lightsources
    public float illuminationStrenght = 0;

    //Defined in tiles
    public float illuminationRange = 0;
    //Todo provjeriti da li je tile light caster ovisno o tome koje objekte ima na sebi ako neki baca svjetlo baca ga i tile...
    public boolean lightCaster = false;

    public Tile(int y, int x) {
        this.y = y;
        this.x = x;
    }

    //Todo Dodati objekte koji su na njemu (stabla itd...)
    //Todo Dodati zvuk kad se hoda po njemu
    //Todo dodati akciju koju izvršava (spawnanje cudovista...)
    //Todo dodati ako se nesto nalazi na podu u screen sastrane iygleda dobra spika
    // ie ako ima neka trava ili nesto sto se ne vidi na glavnom screenu  moyda u 9 polja?


    public int getTileImageID() {
        return tileImageID;
    }

    public void setTileImageID(int tileImageID) {
        this.tileImageID = tileImageID;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isBlockMovement() {
        return blockMovement;
    }

    public void setBlockMovement(boolean blockMovement) {
        this.blockMovement = blockMovement;
    }

    public boolean isBlockJump() {
        return blockJump;
    }

    public void setBlockJump(boolean blockJump) {
        this.blockJump = blockJump;
    }

    public boolean isBlockLOS() {
        return blockLOS;
    }

    public void setBlockLOS(boolean blockLOS) {
        this.blockLOS = blockLOS;
    }

    public boolean isBlockLight() {
        return blockLight;
    }

    public void setBlockLight(boolean blockLight) {
        this.blockLight = blockLight;
    }

    public byte getMovementCost() {
        return movementCost;
    }

    public void setMovementCost(byte movementCost) {
        this.movementCost = movementCost;
    }

    public float getIlluminationStrenght() {
        return illuminationStrenght;
    }

    public void setIlluminationStrenght(float illuminationStrenght) {
        this.illuminationStrenght = illuminationStrenght;
    }

    public float getIlluminationRange() {
        return illuminationRange;
    }

    public void setIlluminationRange(float illuminationRange) {
        this.illuminationRange = illuminationRange;
    }

    public boolean isLightCaster() {
        return lightCaster;
    }

    public void setLightCaster(boolean lightCaster) {
        this.lightCaster = lightCaster;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
