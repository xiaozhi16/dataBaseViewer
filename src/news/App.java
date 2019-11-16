package news;
	
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import DataBase.database;
import controller.NewFEvent;
import controller.OpenFileEvent;
import controller.OpenTableEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import news.contentMenu.TreeDatabaseContextMenu;
import news.contentMenu.TreeTableContentMenu;;

public class App extends Application {
	public static String host;
	public static Connection connection; 
	private TabPane console = new TabPane();
	private TabPane docView= new TabPane();
	private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
    	this.primaryStage=primaryStage;
    	this.login(primaryStage);
    	ArrayList<String> databasesName = database.getDatabase(App.connection);
    	VBox border = new VBox();
    	Scene scene = new Scene(border,800,600);
    	scene.getStylesheets().add("static/application.css");
    	MenuBar menubar = this.buildMenuBar(border);
    	HBox top = this.buildTop();
    	SplitPane bottom = this.buildBottom(scene,databasesName);
    	
    	
    	//top
    	ArrayList<Node> topList = new ArrayList<Node>();
    	top.getChildren().addAll(topList);
    	border.getChildren().add(menubar);
    	border.getChildren().addAll(top,bottom);
    	//topContent
    	VBox.setVgrow(bottom,Priority.ALWAYS);
    	primaryStage.setMinHeight(600);
    	primaryStage.setMinWidth(800);
    	primaryStage.setTitle("Connector1.0");
    	primaryStage.setScene(scene);
    	primaryStage.getIcons().add(new Image("static/icon.png"));
    	primaryStage.show();
    }
    
    private MenuBar buildMenuBar(VBox border) {
		//构建menubar
    	MenuBar menubar = new MenuBar();
    	//文件
    	Menu file = new Menu("文件");
    	MenuItem newF = new MenuItem("新建");
    	newF.setOnAction(new NewFEvent(this.console));
    	MenuItem open = new MenuItem("打开");
    	open.setOnAction(new OpenFileEvent(this.console,this.primaryStage));
    	MenuItem save = new MenuItem("保存");
    	MenuItem saveAs = new MenuItem("另存为");
    	file.getItems().addAll(newF,open,save,saveAs);
    	//视图
    	Menu view = new Menu("视图");
    	MenuItem log = new MenuItem("日志");
    	MenuItem explore = new MenuItem("搜索");
    	view.getItems().addAll(log,explore);
    	//运行
    	Menu debug = new Menu("调试");
    	MenuItem run = new MenuItem("运行");
    	debug.getItems().add(run);
    	//窗口
    	Menu window = new Menu("窗口");
    	Menu help = new Menu("帮助");
    	//file 中的menu
		menubar.getMenus().addAll(file,view,debug,window,help);
    	return menubar;
	}

	/**
     * 	
     *	@param  primaryStage 主窗口
     *	@return 没有返回值
     *
     **/
    private void login(Stage primaryStage) {
		// TODO Auto-generated method stub
		Stage login = new Stage();
		login.getIcons().add(new Image("static/icon.png"));
		login.initOwner(primaryStage);
		login.centerOnScreen();
		login.setIconified(false);
		StackPane stack = new StackPane();
		ImageView hostIcon = new ImageView("static/login/host.png");
		hostIcon.setFitHeight(15);
		hostIcon.setFitWidth(15);
    	Label hostLabel = new Label("Host:");
    	TextField hostInput = new TextField();
    	ImageView userIcon = new ImageView("static/login/user.png");
    	userIcon.setFitHeight(15);
		userIcon.setFitWidth(15);
    	Label userLabel = new Label("User:");
    	TextField userInput = new TextField();
    	ImageView pwdIcon = new ImageView("static/login/pwd.png");
    	pwdIcon.setFitHeight(15);
		pwdIcon.setFitWidth(15);
    	Label pwdLabel = new Label("Password:");
    	TextField pwdInput = new TextField();
    	ImageView portIcon = new ImageView("static/login/port.png");
    	portIcon.setFitHeight(15);
		portIcon.setFitWidth(15);
    	Label portLabel = new Label("port:");
    	TextField portInput = new TextField();
    	GridPane grid = new GridPane();
    	grid.add(hostIcon, 0, 0);
    	grid.add(hostLabel, 1, 0);
    	grid.add(hostInput, 2, 0);
    	grid.add(userIcon, 0, 1);
    	grid.add(userLabel, 1, 1);
    	grid.add(userInput, 2, 1);
    	grid.add(pwdIcon, 0, 2);
    	grid.add(pwdLabel, 1, 2);
    	grid.add(pwdInput, 2, 2);
    	grid.add(portIcon, 0, 3);
    	grid.add(portLabel, 1, 3);
    	grid.add(portInput, 2, 3);
    	GridPane.setHalignment(hostLabel, HPos.RIGHT);
    	GridPane.setMargin(hostLabel, new Insets(10,10,0,0));
    	GridPane.setMargin(hostIcon, new Insets(10,10,0,0));
    	GridPane.setHalignment(hostInput, HPos.RIGHT);
    	GridPane.setMargin(hostInput, new Insets(10,10,0,0));
    	GridPane.setHalignment(userLabel, HPos.RIGHT);
    	GridPane.setMargin(userLabel, new Insets(10,10,0,0));
    	GridPane.setMargin(userIcon, new Insets(10,10,0,0));
    	GridPane.setHalignment(userInput, HPos.RIGHT);
    	GridPane.setMargin(userInput, new Insets(10,10,0,0));
      	GridPane.setHalignment(pwdLabel, HPos.RIGHT);
    	GridPane.setMargin(pwdLabel, new Insets(10,10,0,0));
    	GridPane.setMargin(pwdIcon, new Insets(10,10,0,0));
    	GridPane.setHalignment(pwdInput, HPos.RIGHT);
    	GridPane.setMargin(pwdInput, new Insets(10,10,0,0));
    	GridPane.setHalignment(portLabel, HPos.RIGHT);
    	GridPane.setMargin(portLabel, new Insets(10,10,0,0));
    	GridPane.setMargin(portIcon, new Insets(10,10,0,0));
    	GridPane.setHalignment(portInput, HPos.RIGHT);
    	GridPane.setMargin(portInput, new Insets(10,10,0,0));
		Scene scene = new Scene(stack,400,400);
		Button submit = new Button("login");
		submit.setId("submit");
		GridPane.setMargin(submit, new Insets(60,0,0,0));
		grid.add(submit,0,6,3,1);
		GridPane.setHalignment(submit, HPos.CENTER);
		//grid 搭建完毕
		stack.getChildren().add(grid);
		StackPane.setAlignment(grid,Pos.CENTER);
		scene.getStylesheets().add("static/application.css");
		grid.setId("loginGrid");
		grid.setAlignment(Pos.CENTER);
		login.setScene(scene);
		login.setTitle("Welcom to login");
		login.setResizable(false);
		//设置三个标签
		submit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				Connection connectResult = DataBase.database.connect(hostInput.getText(), userInput.getText(), pwdInput.getText(), portInput.getText());
				if(connectResult != null)
				{
					App.connection = connectResult;
					App.host = hostInput.getText();
					login.close();
				}
			}
		}
		);
		
		login.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				//如果退出就系统退出
				System.exit(0);
			}
		
		});
		
		login.showAndWait();
		
//    	login.setGraphic(new ImageView("static/image/login"));
    }

	@SuppressWarnings("unchecked")
	public SplitPane buildBottom(Scene scene,ArrayList<String> databasesName) throws SQLException {
		SplitPane bottom = new SplitPane();
    	bottom.setId("bottom");
		//左边的折叠式(treeView)面板
    	TreeView<Label> explore = new TreeView<Label>();
    	explore.setPrefWidth(200);
    	explore.setMaxWidth(350);
    	explore.setMinWidth(50);
    	explore.setId("databasesAccordtion");
    	explore.setOnMouseClicked(new OpenTableEvent(this.docView,App.connection,explore));
//    	explore.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Label>>() {
//
//			@Override
//			public void changed(ObservableValue<? extends TreeItem<Label>> arg0, TreeItem<Label> arg1,
//					TreeItem<Label> arg2) {
//				System.out.println(arg0.getValue());
//				
//			}
//		});;
    	//存放折叠面板的子项
    	TreeItem<Label> root=new TreeItem<Label>(new Label(App.host));
    	explore.prefHeightProperty().bind(bottom.prefHeightProperty());
    	root.setExpanded(true);
    	for (String databaseName : databasesName) {
    		ImageView databaseIcon = new ImageView(new Image("static/show/treeview/database.png"));
    		databaseIcon.setFitHeight(15);
    		databaseIcon.setFitWidth(15);
    		Label databasetitleLabel = new Label(databaseName);
    		TreeItem<Label> databaseTitle = new TreeItem<Label>(databasetitleLabel,databaseIcon);
    		databasetitleLabel.setContextMenu(new TreeDatabaseContextMenu(databasetitleLabel.getText()));
			databaseTitle.setExpanded(false);
			ArrayList<String> tablesName = database.getTableName(connection, databaseName);
			for (String tableName : tablesName) {
				ImageView tableIcon = new ImageView(new Image("static/show/treeview/table.png"));
				tableIcon.setFitWidth(15);
				tableIcon.setFitHeight(15);
				Label tabletitleLabel = new Label(tableName);
				TreeItem<Label> tmpTable = new TreeItem<Label>(tabletitleLabel,tableIcon);
				tabletitleLabel.setContextMenu(new TreeTableContentMenu(tabletitleLabel.getText()));
				
				tmpTable.setExpanded(false);
				databaseTitle.getChildren().addAll(tmpTable);
			}
//			databaseTitle.setOnContextMenuRequested(new titleKeyPressed(databaseTitle.getText()));
	    	root.getChildren().add(databaseTitle);
    	}
    	//文档与控制台
    	SplitPane docAndConsole = new SplitPane();
    	docAndConsole.setOrientation(Orientation.VERTICAL);
    	this.console.setPrefHeight(200);
    	this.console.setId("console");
    	Tab welcome = new Tab("Welcom");
    	welcome.setContent(new Label("welcome"));
    	this.docView.getTabs().add(welcome);
    	docAndConsole.getItems().addAll(this.console,this.docView);
    	bottom.getItems().addAll(explore,docAndConsole);
    	bottom.autosize();
    	explore.setRoot(root);
    	//bottom添加
    	bottom.setStyle("-fx-border-width:1px;");
    	bottom.setDividerPositions(0.3);
    	return bottom;
    	
    }
    public HBox buildTop() {
    	HBox top = new HBox();
    	top.setPrefHeight(32);
    	top.setAlignment(Pos.CENTER_LEFT);
    	top.setPadding(new Insets(0,0,0,5));
    	top.setSpacing(5);
    	Button connection = new Button();
    	Button run = new Button();
    	Button stop = new Button();
    	Button file = new Button();
    	Button save = new Button();
    	connection.setId("connectIcon");
    	connection.getStyleClass().add("icon");
    	run.setId("runIcon");
    	run.getStyleClass().add("icon");
    	stop.setId("stopIcon");
    	stop.getStyleClass().add("icon");
    	file.setId("fileIcon");
    	file.getStyleClass().add("icon");
    	save.setId("saveIcon");
    	save.getStyleClass().add("icon");
    	top.getChildren().addAll(connection,file,save,run,stop);
    	
    	
    	return top; 
    }

}
