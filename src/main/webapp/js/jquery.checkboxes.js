/*
 * #%L
 * Accueil CCAS
 * %%
 * Copyright (C) 2012 - 2015 Mairie de Nouméa
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
/**
 *
 * Copyright (c) 2006/2007 Sam Collett (http://www.texotela.co.uk)
 * Licensed under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 * 
 * Version 2.0
 * Demo: http://www.texotela.co.uk/code/jquery/checkboxes/
 *
 * $LastChangedDate$
 * $Rev$
 */

 
/**
 * Toggle all checkboxes contained within a form
 *
 * @name     toggleCheckboxes
 * @param    ignore  Checkboxes to ignore
 * @author   Sam Collett (http://www.texotela.co.uk)
 * @example  $("#myform").toggleCheckboxes();
 * @example  $("#myform").toggleCheckboxes("[@name=ignorethis]");
 *
 */
jQuery.fn.toggleCheckboxes = function(ignore)
{
	ignore = ignore || [];
	return this.each(
		function()
		{
			jQuery("input[@type=checkbox]", this).not(ignore).each(
				function()
				{
					this.checked = !this.checked;
				}
			)
		}
	)
}

/**
 * Check all checkboxes contained within a form
 *
 * @name     checkCheckboxes
 * @param    ignore  Checkboxes to ignore
 * @author   Sam Collett (http://www.texotela.co.uk)
 * @example  $("#myform").checkCheckboxes();
 * @example  $("#myform").checkCheckboxes("[@name=ignorethis]");
 *
 */
jQuery.fn.checkCheckboxes = function(ignore)
{
	ignore = ignore || [];
	return this.each(
		function()
		{
			jQuery("input[@type=checkbox]", this).not(ignore).each(
				function()
				{
					this.checked = true;
				}
			)
		}
	)
}

/**
 * UnCheck all checkboxes contained within a form
 *
 * @name     unCheckCheckboxes
 * @param    ignore  Checkboxes to ignore
 * @author   Sam Collett (http://www.texotela.co.uk)
 * @example  $("#myform").unCheckCheckboxes();
 * @example  $("#myform").unCheckCheckboxes("[@name=ignorethis]");
 *
 */
jQuery.fn.unCheckCheckboxes = function(ignore)
{
	ignore = ignore || [];
	return this.each(
		function()
		{
			jQuery("input[@type=checkbox]", this).not(ignore).each(
				function()
				{
					this.checked = false;
				}
			)
		}
	)
}

/**
 * Makes checkboxes behave like a radio button group
 *   i.e. only one can be selected at a time
 *
 * @name     radioCheckboxGroup
 * @param    name  field name
 * @author   Sam Collett (http://www.texotela.co.uk)
 * @example  $.radioCheckboxGroup("fieldname");
 *
 */
jQuery.radioCheckboxGroup = function(name)
{
	var x = jQuery("input[@name=" + name + "]");
	x.click(
		function()
		{
			// uncheck every other box with the same name
			x.not(this).each(
				function()
				{
					this.checked = false;
				}
			).end();
		}
	);
}