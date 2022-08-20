package com.example.SocialNetwork.factory;

import com.example.SocialNetwork.model.*;

public class ReactFactory {

      public static Reaction createReact(String name) {
          switch(name) {
              case "Laugh" : return new LaughReaction();
              case "Like" : return new LikeReaction();
              case "Sad" : return new SadReaction();
              case "Love" : return new LoveReaction();
              default: return null;
          }
      }

}
