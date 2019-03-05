/*=========================================================================================
    File Name: dashboard-ecommerce.js
    Description: dashboard-ecommerce
    ----------------------------------------------------------------------------------------
    Item Name: Modern Admin - Clean Bootstrap 4 Dashboard HTML Template
    Version: 1.0
    Author: PIXINVENT
    Author URL: http://www.themeforest.net/user/pixinvent
==========================================================================================*/

$(function() {
   
  $("#add-todo-item").on('click', function(e){
    e.preventDefault();
    var todoTitle = $("#new-todo-item").val();
    var todoDesc = $("#new-todo-desc").val();
    var todoTagVal = $("#todo-select").val();
    var badge = "";
    if(todoTagVal != ""){
      var todoTagText = $("#todo-select option:selected").text();
      badge = '<span class="mr-2 badge badge-'+todoTagVal+'">'+ todoTagText +'</span>'
    }
    var description = "";
    if(todoDesc != ""){
      description = '<span class="todo-desc">'+ todoDesc +'</span>';
    }
    if(todoTitle != ""){
      $("#todo-list").append('<div class="todo-item media">'+
                              '<div class="media-left pr-1">'+
                                '<span class="dragme ft-more-vertical"></span>'+
                                '<input type="checkbox" name="todo-item-done" class="todo-item-done" />'+
                              '</div>'+
                              '<div class="media-body">'+
                                '<div class="todo-title">'+ todoTitle +
                                  '<div class="float-right">'+
                                    badge +
                                    '<a class="todo-item-delete"><i class="la la-trash"></i></a>'+
                                  '</div>'+
                                '</div>'+ description +
                              '</div>'+
                            '</div>');
    }
    $("#new-todo-item").val("");
    $("#new-todo-desc").val("");
    $('.todo-list input').iCheck({
      checkboxClass: 'icheckbox_square-blue'
    });
  });
  
  //EVENT DELEGATION
  $("#todo-list").on('click', '.todo-item-delete', function(e){
    var item = this; 
    e.preventDefault();
    $(item).closest('.todo-item').fadeOut('slow', function() { 
      $(item).closest('.todo-item').remove();
    });
  })
  
  $(document).on('ifToggled', '.todo-item-done', function(event){
    $(this).closest('.todo-item').toggleClass("completed");
  });

  // iCheck Checkbox blue
  $('.todo-list input').iCheck({
    checkboxClass: 'icheckbox_square-blue'
  });

  // Filter
  $("#basic-search").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $(".todo-item").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
    var tbl_row = $(".todo-item:visible").length; //here tbl_test is table name
   //Check if table has row or not
      console.log(tbl_row);

    if ( tbl_row === 0 ){
      console.log(tbl_row);
      $('.no-result').removeClass('no-items');
    }
    else{
      if(!$('.no-result').hasClass('no-items') ){
        $('.no-result').addClass('no-items');
      }
    }
  });

  // Selection value for tags
  $(document).on('ifToggled', '.todo-item-done', function(event){
  });

  // Drag the task
  dragula([document.getElementById("todo-list")],{
    moves: function (el, container, handle) {
      return handle.classList.contains('dragme');
    }
  });

  // Scrollbar for task list
  $(".todo-list").perfectScrollbar();

});