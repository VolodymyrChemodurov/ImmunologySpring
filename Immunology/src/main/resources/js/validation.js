	function PatientValidator(){
		$('#validation').bootstrapValidator({
			message: 'This value is not valid',
			fields: {
				
				firstName: {
					message: 'The first name is not valid.',
					validators: {
						notEmpty: {
							message: 'The first rname is required and can\'t be empty.'
						},
						stringLength: {
							min: 2,
							max: 30,
							message: 'The first name must be more than 2 and less than 30 characters long.'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
							message: 'The first name must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				lastName: {
					message: 'The last name is not valid.',
					validators: {
						notEmpty: {
							message: 'The last name is required and can\'t be empty.'
						},
						stringLength: {
							min: 2,
							max: 30,
							message: 'The last name must be more than 2 and less than 30 characters long.'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
							message: 'The last name must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				middleName: {
					message: 'The middle name is not valid.',
					validators: {
						notEmpty: {
							message: 'The middle name is required and can\'t be empty.'
						},
						stringLength: {
							min: 5,
							max: 30,
							message: 'The middle name must be more than 5 and less than 30 characters long.'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
							message: 'The middle name must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				
				region: {
					message: 'The region is not valid.',
					validators: {
						notEmpty: {
							message: 'The region is required and can\'t be empty.'
						},
						stringLength: {
							min: 6,
							max: 30,
							message: 'The region must be more than 6 and less than 30 characters long.'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
							message: 'The region must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				city: {
					message: 'The city is not valid.',
					validators: {
						notEmpty: {
							message: 'The city is required and can\'t be empty.'
						},
						stringLength: {
							min: 3,
							max: 30,
							message: 'The city must be more than 3 and less than 30 characters long.'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
							message: 'The city must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				login: {
					message: 'The login is not valid.',
					validators: {
						notEmpty: {
							message: 'The login is required and can\'t be empty.'
						},
						stringLength: {
							min: 3,
							max: 16,
							message: 'The login must be more than 3 and less than 1630 characters long.'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F0-9]+[-_]?)*$/,
							message: 'The login must contains only letters, numbers, dashes or hyphens.'
						}
					}
				},				
				street: {
					message: 'The street is not valid.',
					validators: {
						notEmpty: {
							message: 'The street is required and can\'t be empty.'
						},
						stringLength: {
							min: 3,
							max: 30,
							message: 'The street must be more than 3 and less than 30 characters long.'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
							message: 'The street name must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				house: {
					message: 'The house is not valid.',
					validators: {
						notEmpty: {
							message: 'The house is required and can\'t be empty.'
						},
						stringLength: {
							min: 1,
							max: 5,
							message: 'The house must be more than 1 and less than 5 characters long.'
						},
						regexp: {
							regexp: /^\d+[a-zA-Z]*$/,
							message: 'The house must contains only letters or numbers.',
						}
					}
				},
				dateOfBirth: {
					message: 'The date is not valid.',
					validators: {
						notEmpty: {
							message: 'The date is required and can\'t be empty.'
						},
						stringLength: {
							min: 10,
							max: 10,
							message: 'The date must be format mm/dd/yyyy'
						},
						regexp: {
							regexp: /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/,
							message: 'The input is not a valid date.',
						}
					}
				},
				
				
				country: {
					validators: {
						notEmpty: {
							message: 'The country is required and can\'t be empty'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
							message: 'The country name must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				sex: {
					validators: {
						notEmpty: {
							message: 'The sex is required and can\'t be empty'
						}
					}
				},
				acceptTerms: {
					validators: {
						notEmpty: {
							message: 'You have to accept the terms and policies'
						}
					}
				},
				email: {
					validators: {
						notEmpty: {
							message: 'The email address is required and can\'t be empty'
						},
						regexp: {
							regexp: /^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\.[a-zA-Z.]+$/,
							message: 'The input is not a valid email address',
						}
					}
				},
				password: {
					validators: {
						notEmpty: {
							message: 'The password is required and can\'t be empty'
						},
						stringLength: {
							min: 8,
							max: 16,
							message: 'The password must be more than 8 and less than 16 characters long.'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F0-9]+[-_]?)*$/,
							message: 'The password must contains only letters, numbers, dashes or hyphens.'
						}
					}
				},	nfirmPassword: {
					validators: {
						notEmpty: {
							message: 'The confirm password is required and can\'t be empty'
						},
						stringLength: {
							min: 8,
							max: 16,
							message: 'The house must be more than 8 and less than 16 characters long.'
						},
						identical: {
							field: 'password',
							message: 'The password and its confirm are not the same'
						},				
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F0-9]+[-_]?)*$/,
							message: 'The password must contains only letters, numbers, dashes or hyphens.'
						}
					}
				}
				
			}
		});
	}
=======
function PatientValidator() {
	$('#defaultForm')
			.bootstrapValidator(
					{
						message : 'This value is not valid',
						fields : {
							firstName : {
								message : 'The first name is not valid.',
								validators : {
									notEmpty : {
										message : 'The first rname is required and can\'t be empty.'
									},
									stringLength : {
										min : 2,
										max : 30,
										message : 'The first name must be more than 2 and less than 30 characters long.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
										message : 'The first name must contains only letters,apostrophe or hyphen.'
									}
								}
							},
							lastName : {
								message : 'The last name is not valid.',
								validators : {
									notEmpty : {
										message : 'The last name is required and can\'t be empty.'
									},
									stringLength : {
										min : 2,
										max : 30,
										message : 'The last name must be more than 2 and less than 30 characters long.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
										message : 'The last name must contains only letters,apostrophe or hyphen.'
									}
								}
							},
							middleName : {
								message : 'The middle name is not valid.',
								validators : {
									notEmpty : {
										message : 'The middle name is required and can\'t be empty.'
									},
									stringLength : {
										min : 5,
										max : 30,
										message : 'The middle name must be more than 5 and less than 30 characters long.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
										message : 'The middle name must contains only letters,apostrophe or hyphen.'
									}
								}
							},

							region : {
								message : 'The region is not valid.',
								validators : {
									notEmpty : {
										message : 'The region is required and can\'t be empty.'
									},
									stringLength : {
										min : 6,
										max : 30,
										message : 'The region must be more than 6 and less than 30 characters long.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
										message : 'The region must contains only letters,apostrophe or hyphen.'
									}
								}
							},
							city : {
								message : 'The city is not valid.',
								validators : {
									notEmpty : {
										message : 'The city is required and can\'t be empty.'
									},
									stringLength : {
										min : 3,
										max : 30,
										message : 'The city must be more than 3 and less than 30 characters long.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
										message : 'The city must contains only letters,apostrophe or hyphen.'
									}
								}
							},
							login : {
								message : 'The login is not valid.',
								validators : {
									notEmpty : {
										message : 'The login is required and can\'t be empty.'
									},
									stringLength : {
										min : 3,
										max : 16,
										message : 'The login must be more than 3 and less than 1630 characters long.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F0-9]+[-_]?)*$/,
										message : 'The login must contains only letters, numbers, dashes or hyphens.'
									}
								}
							},
							street : {
								message : 'The street is not valid.',
								validators : {
									notEmpty : {
										message : 'The street is required and can\'t be empty.'
									},
									stringLength : {
										min : 3,
										max : 30,
										message : 'The street must be more than 3 and less than 30 characters long.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
										message : 'The street name must contains only letters,apostrophe or hyphen.'
									}
								}
							},
							house : {
								message : 'The house is not valid.',
								validators : {
									notEmpty : {
										message : 'The house is required and can\'t be empty.'
									},
									stringLength : {
										min : 1,
										max : 5,
										message : 'The house must be more than 1 and less than 5 characters long.'
									},
									regexp : {
										regexp : /^\d+[a-zA-Z]*$/,
										message : 'The house must contains only letters or numbers.',
									}
								}
							},
							dateOfBirth : {
								message : 'The date is not valid.',
								validators : {
									notEmpty : {
										message : 'The date is required and can\'t be empty.'
									},
									stringLength : {
										min : 10,
										max : 10,
										message : 'The date must be format mm/dd/yyyy'
									},
									regexp : {
										regexp : /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/,
										message : 'The input is not a valid date.',
									}
								}
							},

							country : {
								validators : {
									notEmpty : {
										message : 'The country is required and can\'t be empty'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F]+[-']?)*$/,
										message : 'The country name must contains only letters,apostrophe or hyphen.'
									}
								}
							},
							sex : {
								validators : {
									notEmpty : {
										message : 'The sex is required and can\'t be empty'
									}
								}
							},
							acceptTerms : {
								validators : {
									notEmpty : {
										message : 'You have to accept the terms and policies'
									}
								}
							},
							email : {
								validators : {
									notEmpty : {
										message : 'The email address is required and can\'t be empty'
									},
									regexp : {
										regexp : /^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\.[a-zA-Z.]+$/,
										message : 'The input is not a valid email address',
									}
								}
							}

						}
					});
}

function PasswordValidator() {
	$('#defaultForm-password')
			.bootstrapValidator(
					{
						fields : {
							oldPassword : {
								validators : {
									notEmpty : {
										message : 'The password is required and can\'t be empty'
									},
									stringLength : {
										min : 8,
										max : 16,
										message : 'The password must be more than 8 and less than 16 characters long.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F0-9]+[-_]?)*$/,
										message : 'The password must contains only letters, numbers, dashes or hyphens.'
									}
								}
							},
							password : {
								validators : {
									notEmpty : {
										message : 'The password is required and can\'t be empty'
									},
									stringLength : {
										min : 8,
										max : 16,
										message : 'The password must be more than 8 and less than 16 characters long.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F0-9]+[-_]?)*$/,
										message : 'The password must contains only letters, numbers, dashes or hyphens.'
									}
								}
							},
							confirmPassword : {
								validators : {
									notEmpty : {
										message : 'The confirm password is required and can\'t be empty'
									},
									stringLength : {
										min : 8,
										max : 16,
										message : 'The house must be more than 8 and less than 16 characters long.'
									},
									identical : {
										field : 'password',
										message : 'The password and its confirm musr be the same.'
									},
									regexp : {
										regexp : /^([a-zA-Z\u0400-\u052F0-9]+[-_]?)*$/,
										message : 'The password must contains only letters, numbers, dashes or hyphens.'
									}
								}
							}

						}
					});
}