format 76

activitycanvas 128002 activity_ref 128770 // setup hall
  show_infonote default drawing_language default show_stereotype_properties default
  xyzwh 1 3 2000 793 1177
end
activitynodecanvas 128514 activitynode_ref 131330 // initial_node
  xyz 185 117 2005
end
activityactioncanvas 128642 activityaction_ref 131970 // activity action warden is created
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 97 202 2005 100 60
end
activitynodecanvas 128898 activitynode_ref 131586 // fork
  horizontal  xyzwh 135 167 2005 117 15
end
activityactioncanvas 129026 activityaction_ref 132098 // activity action mess manager is recruited
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 153 276 2005 100 60
end
activityactioncanvas 129154 activityaction_ref 132226 // activity action hall is created
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 131 470 2005 100 60
end
activityactioncanvas 129282 activityaction_ref 132354 // activity action hall status is set
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 131 566 2005 100 60
end
activityactioncanvas 129410 activityaction_ref 132482 // activity action rooms are added
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 134 653 2005 100 60
end
activityactioncanvas 129538 activityaction_ref 132610 // activity action room rents are added
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 138 735 2005 100 60
end
activityactioncanvas 129666 activityaction_ref 132738 // activity action warden is assigned
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 142 816 2005 100 60
end
activityactioncanvas 129794 activityaction_ref 132866 // activity action mess manager is assigned
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 144 898 2005 100 60
end
activityactioncanvas 129922 activityaction_ref 132994 // activity action recruit clerk
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 491 265 2005 100 60
end
activityactioncanvas 130050 activityaction_ref 133122 // activity action recruit daily workers
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 492 402 2005 100 60
end
activitynodecanvas 130562 activitynode_ref 131714 // join
  horizontal  xyzwh 131 400 2005 129 15
end
activitynodecanvas 132482 activitynode_ref 131842 // activity_final
  xyz 529 522 2005
end
activitypartitioncanvas 133378 activitypartition_ref 136066 // HMC
  xyzwh 77 55 2011 274 962
end
activitypartitioncanvas 133506 activitypartition_ref 136194 // warden
  xyzwh 349 55 2013 342 962
end
activityactioncanvas 133634 activityaction_ref 140930 // activity action sets hall's amenity charge
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 492 159 2010 100 60
end
flowcanvas 130178 flow_ref 136962 // <flow>
  
  from ref 128514 z 2006 to ref 128898
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130306 flow_ref 137090 // <flow>
  decenter_begin 93
  
  from ref 128898 z 2006 to ref 128642
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130434 flow_ref 137218 // <flow>
  decenter_begin 750
  decenter_end 699
  
  from ref 128898 z 2006 to ref 129026
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130690 flow_ref 137346 // <flow>
  decenter_begin 469
  decenter_end 100
  
  from ref 128642 z 2006 to ref 130562
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130818 flow_ref 137474 // <flow>
  decenter_end 532
  
  from ref 129026 z 2006 to ref 130562
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130946 flow_ref 137602 // <flow>
  decenter_begin 386
  
  from ref 130562 z 2006 to ref 129154
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131458 flow_ref 137730 // <flow>
  
  from ref 129154 z 2006 to ref 129282
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131586 flow_ref 137858 // <flow>
  
  from ref 129282 z 2006 to ref 129410
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131714 flow_ref 137986 // <flow>
  
  from ref 129410 z 2006 to ref 129538
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131842 flow_ref 138114 // <flow>
  
  from ref 129538 z 2006 to ref 129666
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 132354 flow_ref 138370 // <flow>
  
  from ref 129922 z 2006 to ref 130050
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 132610 flow_ref 138498 // <flow>
  
  from ref 130050 z 2006 to ref 132482
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 132738 flow_ref 146690 // <flow>
  
  from ref 129666 z 2006 to ref 129794
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 133762 flow_ref 146946 // <flow>
  
  from ref 133634 z 2011 to ref 129922
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 133890 flow_ref 147074 // <flow>
  
  from ref 129794 z 2006 to point 297 924
  line 134018 z 2006 to point 297 185
  line 134146 z 2006 to ref 133634
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
end
