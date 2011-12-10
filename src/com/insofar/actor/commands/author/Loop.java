package com.insofar.actor.commands.author;

import com.insofar.actor.author.EntityActor;

/**
 * ActorPlugin command to set looping on an actor (or "all")
 * 
 * @author Joshua Weinberg
 *
 */
public class Loop extends AuthorBaseCommand {

	public Loop()
	{
		super();
	}

	/*********************************************************************
	 * 
	 * BUKKIT COMMAND
	 * 
	 *********************************************************************/

	@Override
	/**
	 * bukkit command to turn loop on or off for one or "all" actors
	 */
	public boolean execute()
	{
		if (args.length != 2)
		{
			player.sendMessage("Error: Usage: /loop [on|off] ActorName. ActorName can be 'all'");
			return true;
		}
		
		boolean loop = args[0].equals("on") ? true : false;
		String actorName = args[1];
		
		for (EntityActor actor : plugin.actors)
		{
			if (actor.hasViewer(player) && (actor.name.equals(actorName) || actorName.equals("all")))
			{
				actor.loop = loop;
			}
		}
		
		return true;
	}
	
}