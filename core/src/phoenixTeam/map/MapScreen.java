package phoenixTeam.map;

import phoenixTeam.Main;
import phoenixTeam.entity.living.enemy.EntitySlime;
import phoenixTeam.entity.living.player.EntityPlayer;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MapScreen extends ScreenAdapter{

	OrthographicCamera camera;
	
	Map map;
	Engine engine;
	
	EntityPlayer player;
	
	public MapScreen(){
		engine = new Engine();
		
		map = new Map(100, 100);
		
		//Add the player to the map.
		player = new EntityPlayer(map, camera);
		map.spawnEntity(player);
		
		//Add the familiar
		//currentMap.spawnEntity(new EntityChris(10, 10, currentMap, player));

		//Add a slime
		map.spawnEntity(new EntitySlime(10, 10));
		map.spawnEntity(new EntitySlime(50, 50));
		map.spawnEntity(new EntitySlime(60, 60));
	}
	
	@Override
	public void render(float delta) {
		
		//Set the batch to adjust for the camera
		Main.batch.setProjectionMatrix(camera.combined);
		
		//Tick the map
		map.onTick();
		
		map.display(camera, Main.batch);
	}

}