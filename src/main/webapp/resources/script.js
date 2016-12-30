/**
 * Created by the-red-paintings on 30.12.2016.
 */
/**
 * Created by the-red-paintings on 30.12.2016.
 */
/**
 * Created by the-red-paintings on 30.12.2016.
 */
function tableToJSON(){
    var container = new Object();
    container.list = [];
    var list;

    for(i = 0; i <document.getElementById("table").rows.length-1; i++) {
        var client = {"idClient": document.getElementById("list"+i+".idClient").value,
            "telefone": {"idTelefone": document.getElementById("list"+i+".telefone.idTelefone").value
                , "number": document.getElementById("list"+i+".telefone.number").value
                , "type": document.getElementById("list"+i+".telefone.type").value
                , "comment": document.getElementById("list"+i+".telefone.comment").value
            }, "fio": document.getElementById("list"+i+".fio").value
        };

        container.list.push(client);

    }
    console.log(JSON.stringify(container));
    return JSON.stringify(container);
};




function searchAjax() {
    // Convert the table into a javascript object
    console.log(table);
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "updateAll",
        data : tableToJSON(),
        //dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            console.log();
            //document.getElementById("list0.fio").value = "Max Captain";

            console.log(data.list);
            $(function(){
                for(i = 0; i<=data.list.length; i++){
                    console.log(data.list[i]);
                    document.getElementById("list"+i+".fio").value = data.list[i].fio;
                    document.getElementById("list"+i+".idClient").value = data.list[i].idClient;

                    document.getElementById("list"+i+".telefone.number").value = data.list[i].telefone.number;
                    document.getElementById("list"+i+".telefone.type").value = data.list[i].telefone.type;
                    document.getElementById("list"+i+".telefone.comment").value = data.list[i].telefone.comment;
                    document.getElementById("list"+i+".telefone.idTelefone").value = data.list[i].telefone.idTelefone;
                    i++;
                };
            });


        },
        error : function(e) {
            console.log("ERROR: ", e);

        },
        done : function(e) {

        }
    });
}