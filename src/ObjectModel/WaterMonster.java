package ObjectModel;


public class WaterMonster extends Monster{

	public WaterMonster(String name, int live, int attack, SkillType skill){
		super(name, live, attack, skill);
	}

	@Override
	public boolean attackingUsingSkill(Monster enemyMonster, boolean isSkillUsed) {
		return super.attackUsingSkill(enemyMonster, isSkillUsed);
	}
	
}
