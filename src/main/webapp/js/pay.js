$(document).ready(function() {
  $('.btn a').click(function() {
	 // var userId = document.getElementById("userid").value;
		//window.location.href = '/buygood.do?userid=' + userId;
    // 弹出确认付款的弹窗
    var confirmDialog = confirm('确认付款吗？');
        
    if (confirmDialog) {
      // 弹出付款成功的弹窗
      var successDialog = alert('付款成功！');
      setTimeout(function() {
        // 关闭付款成功弹窗
        
        successDialog.close();
        // 发送购买成功邮件
        ///window.location.href = '/buygood.do?userid=';
        
      }, 3000);
    } else {
      // 弹出付款失败的弹窗
      var failDialog = alert('付款失败！');
      setTimeout(function() {
        // 关闭付款失败弹窗
        failDialog.close();
      }, 3000);
    }
  });
});

function sendEmail() {
  // 发送邮件的逻辑
  // TODO: 根据需求编写发送邮件的代码
}
