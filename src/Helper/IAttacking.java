package Helper;

import ObjectModel.Monster;

public interface IAttacking {
	abstract boolean attackingUsingSkill(Monster enemyMonster, boolean isSkillUsed);
}
