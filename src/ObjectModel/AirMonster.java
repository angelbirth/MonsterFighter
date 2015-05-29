package ObjectModel;


public class AirMonster extends Monster{

	public AirMonster(String name, int live, int attack, SkillType skill){
		super.createMonster(name, live, attack, skill);
	}
	
	@Override
	public boolean attackingUsingSkill(Monster enemyMonster, boolean isSkillUsed) {
		return super.attackUsingSkill(enemyMonster, isSkillUsed);
	}

}
