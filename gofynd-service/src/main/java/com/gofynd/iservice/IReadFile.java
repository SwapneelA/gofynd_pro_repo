/**
 * 
 */
package com.gofynd.iservice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.gofynd.bean.ItemToDisplay;

/**
 * @author GRO
 *
 */
public interface IReadFile {
	void readCSVFile(File f) throws IOException;
}
