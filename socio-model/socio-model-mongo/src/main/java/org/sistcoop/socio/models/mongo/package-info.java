/**
 * 
 */
/**
 * @author Huertas
 *
 */



@GenericGenerators(
		value = { 
				@GenericGenerator(name = "SgGenericGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
						@Parameter(name = "prefer_sequence_per_entity", value = "true"),
						@Parameter(name = "optimizer ", value = "pooled") }) 
				}
		)
package org.sistcoop.socio.models.mongo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.annotations.Parameter;

