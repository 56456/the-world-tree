package com.ggq.worldtree.usercenter.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ggq.worldtree.common.validate.annotation.EnumValid;
import com.ggq.worldtree.common.validate.group.Edit;
import com.ggq.worldtree.common.validate.group.Login;
import com.ggq.worldtree.common.validate.group.Register;
import com.ggq.worldtree.usercenter.enums.Gender;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema
public class User implements Serializable {

	@NotBlank(message = "编号不能为空",groups = {Edit.class, Register.class})
	@Schema( name = "id编号",example = "1")
	private Long id;
		
	@NotBlank(message = "用户名不能为空",groups = {Login.class, Edit.class, Register.class})
	@Schema(name = "用户名",example = "zhangsan")
	private String userName;
		
	@NotBlank(message = "姓名不能为空",groups = {Edit.class, Register.class})
	@Schema(name = "姓名",example = "张三")
	private String realName;
		
	@NotBlank(message = "密码不能为空",groups = {Login.class, Edit.class, Register.class})
	@Size(max=32,min=6,message = "密码长度要在6-32之间",groups = {Login.class, Edit.class, Register.class})
	@Schema(name = "密码",example = "123456")
	private String password;

	@NotNull(message = "性别不能为空",groups = {Edit.class, Register.class})
	@Schema(name = "性别",example = "1")
	@EnumValid(target = Gender.class, message = "性别值不符合规范,您? 您是hentai?",groups = {Edit.class, Register.class})
	private Integer gender;
		
	@Schema(name = "邮箱",example = "zhangsan@qq.com")
	@Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message = "不满足邮箱正则表达式",groups = {Edit.class, Register.class})
	private String email;



}
