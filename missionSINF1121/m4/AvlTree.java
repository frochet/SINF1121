    

   
    /**
     * Class AVLtree
     * Auteur Florentin, Abdel
     * @param <K>
     */
    public class AvlTree<E, K>
    {

          /** The tree root. */
        private AvlNode<E, K> root;
        /**
         * Create a new isntance of the AVLTree
         */
        public AvlTree( )
        {
            root = null;
        }

       /**
        *
        *
        * @param x
        * @param obj
        */
        public void insert( K x,E obj )
        {
            root = insert( x,obj, root );
        }

        /**
         *
         * @param x
         */
        public void remove( K x )
        {
           
        }

       /**
        *
        * @return
        */
        public K findMin( )
        {
            return elementAt( findMin( root ) );
        }

        /**
         *
         * @return
         */
        public K findMax( )
        {
            return elementAt( findMax( root ) );
        }

       /**
        *
        * @param x
        * @return
        */
        public K find( K x )
        {
            return elementAt( find( x, root ) );
        }

       

        /**
         *
         * @return
         */
        public boolean isEmpty( )
        {
            return root == null;
        }

       /**
        *
        */
        public void printTree( )
        {
            if( isEmpty( ) )
                System.out.println( "Tree Empty" );
            else
                printTree( root );
        }

       /**
        *
        * @param t
        * @return
        */
        private K elementAt( AvlNode<E,K> t )
        {
            return t == null ? null : t.getElement();
        }

        /**
         *
         * @param x
         * @param obj
         * @param t
         * @return
         */
        private AvlNode<E, K> insert( K x,E obj, AvlNode<E, K> t )
        {
            if( t == null )
                t = new AvlNode<E,K>( x,obj, null, null );
            else if( t.compareTo(x) < 0 )
            {
                t.setLeft(insert( x,obj, t.getLeft() ));
                if( height( t.getLeft() ) - height( t.getRight() ) == 2 )
                    if( t.compareTo(x) < 0 )
                        t = rotateWithLeftChild( t );
                    else
                        t = doubleWithLeftChild( t );
            }
            else if( t.compareTo(x) > 0 )
            {
                t.setRight(insert( x,obj, t.getRight() ));
                if( height( t.getRight() ) - height( t.getLeft() ) == 2 )
                    if( t.compareTo(x) > 0 )
                        t = rotateWithRightChild( t );
                    else
                        t = doubleWithRightChild( t );
            }
            else
                ;  // Duplicate; do nothing
            t.setHeight( max( height( t.getLeft() ), height( t.getRight() ) ) + 1);
            return t;
        }

        /**
         *
         * @param t
         * @return
         */
        private AvlNode<E, K> findMin( AvlNode<E, K> t )
        {
            if( t == null )
                return t;

            while( t.getLeft() != null )
                t = t.getLeft();
            return t;
        }

        /**
         *
         * @param t
         * @return
         */
        private AvlNode<E, K> findMax( AvlNode<E, K> t )
        {
            if( t == null )
                return t;

            while( t.getRight() != null )
                t = t.getRight();
            return t;
        }

        /**
         *
         * @param x
         * @param t
         * @return
         */
        private AvlNode<E, K> find( K x, AvlNode<E, K> t )
        {
            while( t != null )
                if( t.compareTo(x) < 0 )
                    t = t.getLeft();
                else if( t.compareTo(x) > 0 )
                    t = t.getRight();
                else
                    return t;    // Match

            return null;   // No match
        }

        /**
         *
         * @param t
         */
        private void printTree( AvlNode<E, K> t )
        {
            if( t != null )
            {
                printTree( t.getLeft() );
                System.out.println( t.getObject() );
                printTree( t.getRight() );
            }
        }

        /**
         * Return the height of node t, or -1, if null.
         */
        private  int height( AvlNode<E, K> t )
        {
            return t == null ? -1 : t.getHeight();
        }

        /**
         * Return maximum of lhs and rhs.
         */
        private static int max( int lhs, int rhs )
        {
            return lhs > rhs ? lhs : rhs;
        }

      /**
       *
       * @param k2
       * @return
       */
        private AvlNode<E, K> rotateWithLeftChild( AvlNode<E, K> k2 )
        {
            AvlNode<E, K> k1 = k2.getLeft();
            k2.setLeft(k1.getRight());
            k1.setRight(k2);
            k2.setHeight( max( height( k2.getLeft() ), height( k2.getRight() ) ) + 1);
            k1.setHeight(max( height( k1.getLeft() ), k2.getHeight() ) + 1);
            return k1;
        }

        /**
         *
         * @param k1
         * @return
         */
        private AvlNode<E, K> rotateWithRightChild( AvlNode<E, K> k1 )
        {
            AvlNode<E, K> k2 = k1.getRight();
            k1.setRight( k2.getLeft());
            k2.setLeft( k1);
            k1.setHeight( max( height( k1.getLeft() ), height( k1.getRight() ) ) + 1);
            k2.setHeight( max( height( k2.getRight() ), k1.getHeight() ) + 1);
            return k2;
        }

        /**
         *
         * @param k3
         * @return
         */
        private AvlNode<E, K> doubleWithLeftChild( AvlNode<E, K> k3 )
        {
            k3.setLeft(rotateWithRightChild( k3.getLeft() ));
            return rotateWithLeftChild( k3 );
        }

        /**
         *
         * @param k1
         * @return
         */
        private AvlNode<E, K> doubleWithRightChild( AvlNode<E, K> k1 )
        {
            k1.setRight(rotateWithLeftChild( k1.getRight() ));
            return rotateWithRightChild( k1 );
        }

}
