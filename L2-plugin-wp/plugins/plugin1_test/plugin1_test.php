<?php
/**
 * Plugin name: XD
 * 
 */
function mfp_Add_Text() { 
    echo"<p style='color: red;'>Ten tekst wyświetla się po wygenerowaniu stopki strony</p>"; 
    // Hook the 'wp_footer' action hook, add the function named 'mfp_Add_Text' to 
}
add_action("wp_footer", "mfp_Add_Text");
function naph_admin_actions_register_menu(){  
    add_options_page("Newly Added Post Highliter", "New Post Highliter", 'manage_options', "naph", "naph_admin_page");    
}                                                                                
add_action('admin_menu', 'naph_admin_actions_register_menu');

function naph_admin_page(){ // get _POST variable from globals                                             
    global $_POST; // process changes from form
    if(isset($_POST['naph_do_change'])){ 
        if($_POST['naph_do_change'] == 'Y'){ 
            $opDays = $_POST['naph_days']; 
            echo'<div class="notice notice-success is-dismissible"><p>Settings saved.</p></div>'; 
        update_option('naph_days', $opDays);     
        }      
    }
    $opDays = get_option('naph_days'); 

// display admin page
?>

<div class="wrap">
    <h1>Newly Added Post Highliter</h1>
    <form name="naph_form"method="post">
        <input type="hidden"name="naph_do_change"value="Y">
        <p>Highlight post title for 
            <input type="number"name="naph_days"min="0"max="30"value="
            <?php echo $opDays?>"> days </p>
            <p class="submit"><input type="submit"value="Submit"></p>
        </form>
    </div>
<?php
}
function naph_mark_new_post_title($content, $id){ 
    //read post publish date
    $date = get_the_date('Ymd', $id); 
    //get current date
    $now = date('Ymd'); //get setting for how long post is a new post
    $opDays = get_option('naph_days');
    //generate proper post title
    if($now - $date <= $opDays) 
        return$content."<sup class=\"naph_marker\">new</sup>";
    return$content; 
} 
add_filter("the_title", "naph_mark_new_post_title", 10, 2);

function naph_register_styles(){ 
    //register style
    wp_register_style('naph_styles', plugins_url('/css/style.css', __FILE__)); 
    //enable style (load in meta of html)
    wp_enqueue_style('naph_styles'); 
} 
add_action('init', 'naph_register_styles');

function remove_dashboard_elements(){
    // remove_menu_page('edit.php'); // Posts
    // remove_menu_page('upload.php'); // Media
    // remove_menu_page('link-manager.php'); // Links
    remove_menu_page('edit-comments.php'); // Comments
    // remove_menu_page('edit.php?post_type=page'); // Pages
    // remove_menu_page('plugins.php'); // Plugins
    // remove_menu_page('themes.php'); // Appearance
    remove_menu_page('users.php'); // Users
    remove_menu_page('tools.php'); // Tools
    // remove_menu_page('export-personal-data.php'); // Tools
    // remove_menu_page('options-general.php'); // Settings
}
add_action('wp_dashboard_setup', 'remove_dashboard_elements' );