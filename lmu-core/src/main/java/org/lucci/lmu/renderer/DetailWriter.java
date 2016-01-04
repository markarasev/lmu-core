package org.lucci.lmu.renderer;

import org.lucci.lmu.model.Entities;
import org.lucci.lmu.model.Entity;
import org.lucci.lmu.model.IModel;
import org.lucci.lmu.model.Model;
import org.lucci.lmu.output.AbstractWriter;
import org.lucci.lmu.output.WriterException;

public class DetailWriter extends AbstractWriter
{

	@Override
	public byte[] writeModel(IModel model) throws WriterException
	{
		StringBuilder b = new StringBuilder();

		b.append("Entities\n");
		for (Entity e : model.getEntities())
		{
			b.append(e.getName()+"\n");
		}

		b.append("Isolated entities\n");
		for (Entity e : Entities.findIsolatedEntities(model.getEntities(), model))
		{
			b.append(e.getName()+"\n");
		}
		
		
		return b.toString().getBytes();
	}

}
