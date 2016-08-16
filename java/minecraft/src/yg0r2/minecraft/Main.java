/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package yg0r2.minecraft;

import java.io.IOException;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import yg0r2.core.util.SpringUtils;
import yg0r2.minecraft.spring.BaseBean;
import yg0r2.minecraft.spring.BeanUtil;
import yg0r2.minecraft.spring.ModBean;
import yg0r2.minecraft.spring.PathBean;
import yg0r2.minecraft.spring.ResourcePackBean;

/**
 * @author Yg0R2
 */
public class Main {

	private static Logger _LOGGER = LoggerFactory.getLogger(Main.class);

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		_LOGGER.info("Download Mods:");

		_doDownload("modsLocation", ModBean.class);

		_LOGGER.info("Download ResourcePacks:");

		_doDownload("resourcePacksLocation", ResourcePackBean.class);
	}

	private static void _doDownload(String beanId, Class<? extends BaseBean> beanType) throws IOException {
		Path path = SpringUtils.getBean(PathBean.class, Main.class, beanId).getLocation();

		for (BaseBean bean : SpringUtils.getBeansOfType(beanType, Main.class)) {
			BeanUtil.download(bean, path);
		}
	}

}
