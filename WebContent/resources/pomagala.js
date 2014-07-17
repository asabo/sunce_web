
(function($){
  // `Backbone.sync`: Overrides persistence storage with dummy function. This enables use of `Model.destroy()` without raising an error.
//  Backbone.sync = function(method, model, success, error){
//    success();
//  }

  var Item = Backbone.Model.extend({
	  urlRoot: 'rest/v1/pomagala'
  });

  var List = Backbone.Collection.extend({
    model: Item,
    url: 'rest/v1/pomagala'
  });

  var ItemView = Backbone.View.extend({
    tagName: 'tr', // name of tag to be created
    // `ItemView`s now respond to two clickable actions for each `Item`: swap and delete.
    events: {
      'click span.delete': 'remove',
      'click td.naziv': 'uredi'
    },
    // `initialize()` now binds model change/removal to the corresponding handlers below.
    initialize: function(){
      _.bindAll(this, 'render', 'unrender', 'remove'); // every function that uses 'this' as the current object should be in here

      this.model.bind('change', this.render);
      this.model.bind('remove', this.unrender);
    },
    // `render()` now includes two extra `span`s corresponding to the actions swap and delete.
    render: function(){
      //this.$el.html(this.template(this.model.attributes));
      $(this.el).html('<td>'+
    		  this.model.get('sifraArtikla')+'</td>'+
    		  '<td class="naziv"><span id="nazivSpan" class="nazivSpan">'+this.model.get('naziv')+'</span></td>'+
    		  '<td align="right">'+(this.model.get('cijenaSPDVom')/100.0)+'</td>'+
    		  '<td><span class="delete">del</span>');
      return this; // for chainable calls, like .render().el
    },
    uredi:function(evt) {
        var elem = evt.currentTarget;
                 
        var nazivSpan = $("#nazivSpan", elem);
        var nazivInput = $("#nazivInput", nazivSpan);
    
        if (nazivInput.length > 0)        	
        	return;
        
        nazivSpan.html('<input id="nazivInput" style="width:100%;" value="'+this.model.get('naziv')+'"></input>');
        
        nazivInput = $("#nazivInput", nazivSpan);
        nazivInput.focus();
        
        var model=this.model;
        
        nazivInput.focusout( "focuslost", function(evt) {
        	 
        	var nazivSpan = this.parentNode;
        	var tekst=this.value;
         
        	nazivSpan.innerText=tekst;
        	model.set('naziv',tekst);
        	model.save();
        	});
         
     }
    ,
    // `unrender()`: Makes Model remove itself from the DOM.
    unrender: function(){
      $(this.el).remove();
    },
    remove: function(){
      this.model.destroy();
    }
  });

  // Because the new features (swap and delete) are intrinsic to each `Item`, there is no need to modify `ListView`.
  var ListView = Backbone.View.extend({
    el: $('body'), // el attaches to existing element
    events: {
      'click button#add': 'addItem'
    },
    initialize: function(){
      _.bindAll(this, 'render', 'addItem', 'appendItem'); // every function that uses 'this' as the current object should be in here

      this.collection = new List();
      this.collection.fetch();
      this.collection.bind('add', this.appendItem); // collection event binder

      this.counter = 0;
      this.render();
    },
    render: function(){
      var self = this;
      $(this.el).append("<table id='pomagalaTablica' class='lista'><tr><th>sifra<th>naziv<th>cijena</tr></table>");
      _(this.collection.models).each(function(item){ // in case collection is not empty
        self.appendItem(item);
      }, this);
    },
    addItem: function(){
      this.counter++;
      var item = new Item();
      item.set({
        part2: item.get('part2') + this.counter // modify item defaults
      });
      this.collection.add(item);
    },
    appendItem: function(item){
      var itemView = new ItemView({
        model: item
      });
      $('#pomagalaTablica', this.el).append(itemView.render().el);
     
    }
  });

  var listView = new ListView();
})(jQuery);
