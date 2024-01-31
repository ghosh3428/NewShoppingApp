$(function() 
{
	var $table = $('#producttable');
	
	
	var jsonUrl = '';
		if (window.categoryID == '') {
			jsonUrl = window.contextRoot + '/json/show/all/active/products';
		} else {
			jsonUrl = window.contextRoot + '/json/show/all/active/category/'
					+ window.categoryID + '/products';
		}
		
	$table.DataTable({
		
		lengthMenu : [ [ 3, 5, 10, -1 ], [ '3 Products', '5 Products', '10 Products', 'ALL Products' ] ],
		pageLength : 5,
		ajax : {
						url : jsonUrl,
						dataSrc : '',
					},
		columns : [
					{
						data:'code',
						mRender :function(data, type, row)
							{
								return '<img src="' + window.contextRoot
											+ '/rs/images/' + data
											+ '.jpg" class="dataTableImg"/>';
											
							}
						
				
					},
					{
						data:'code',
						bSortable: false,
				
					}	,
					{
						data:'name'
					}	,
					{
						data :'brand'
					}	,
					{
						data:'quantity',
						mRender :function(data, type, row)
							{
								if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;
							}
					},
					{
						data:'unitPrice',
						mRender :function(data, type, row)
							{
								return '&#8377; ' + data
							}
					},
					{
						data:'id',
						mRender :function(data, type, row)
							{
								var str =  '<a class="btn btn-primary" href="'+ window.contextRoot
											+ '/product/show/single/'
											+ data
											+ '/product">View</a>'
						
						
								if (row.quantity < 1) 
								{
														str += '<a href="javascript:void(0)" class="btn btn-warning disabled"><strike>Cart</strike></a>';
								} 
								else 
								{

														str += '<a href="'
																+ window.contextRoot
																+ '/cart/add/'
																+ data
																+ '/product" class="btn btn-warning">Cart</a>';
													}
													
							 return str;
							}
						
					}
				],
		});	
		
		
		
		
		
		
		
		// ADMIN PRODUCT TABLE CODE
		
		var $table = $('#adminProductsTable');
		
		
		var jsonUrl =  window.contextRoot + '/json/show/all/products';
		
		
	$table.DataTable({
		
		lengthMenu : [ [ 3, 5, 10, -1 ], [ '3 Products', '5 Products', '10 Products', 'ALL Products' ] ],
		pageLength : 5,
		ajax : {
						url : jsonUrl,
						dataSrc : '',
					},
		columns : [
					{
						data:'id',
						
					},
					{
						data:'name'
					}	,
					{
						data :'brand'
					}	,
					{
						data:'quantity',
					},
					{
						data:'unitPrice',
						mRender :function(data, type, row)
							{
								return '&#8377; ' + data
							}
					},
					{
						data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if (data) {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '" checked="checked">  <div class="slider round"> </div></label>';

									} else {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '">  <div class="slider round"> </div></label>';
									}

									return str;
								}
					},
					{
						data:'id',
						mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil">EDIT</span></a> &#160;';

									return str;
								}
					}
						
				]
		});	
		
		
});